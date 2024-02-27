limport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.lang.model.element.ElementVisitor;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


public class customSort {
	
	public static void main(String[] args) throws Exception{ 
		
		String input = "/lab3_2/input-500k";
		String temp = "/lab3_2/temp1";
		String output = "/lab3_2/output1";
		
		int reduceNumber = 10;
		
		Configuration conf = new Configuration();		
		
		
		Job job = Job.getInstance(conf, "Exp2");
		
		job.setJarByClass(customSort.class);
		job.setNumReduceTasks(reduceNumber);
	
		job.setMapperClass(mapOne.class);
		job.setReducerClass(reduceOne.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setInputFormatClass(KeyValueTextInputFormat.class); 
		job.setOutputFormatClass(TextOutputFormat.class);
		
		
		FileInputFormat.addInputPath(job, new Path(input));

		FileOutputFormat.setOutputPath(job, new Path(temp));
		
		job.waitForCompletion(true);
		
		
		Job job_two = Job.getInstance(conf, "Round Two");
        job_two.setJarByClass(customSort.class);
        
        conf.setInt("Count", 0);
        // Providing the number of reducers for the second round
        reduceNumber = 10;
        job_two.setNumReduceTasks(reduceNumber);

        // Should be match with the output datatype of mapper and reducer
        job_two.setMapOutputKeyClass(Text.class);
        job_two.setMapOutputValueClass(Text.class);
         
        job_two.setOutputKeyClass(Text.class);
        job_two.setOutputValueClass(Text.class);
        //job_two.setPartitionerClass(MyPartitioner.class);
         
        job_two.setMapperClass(mapTwo.class);
        job_two.setReducerClass(reduceTwo.class);
        
        
        // Partitioner is our custom partitioner class
        job_two.setPartitionerClass(MyPartitioner.class);
        
        // Input and output format class
        job_two.setInputFormatClass(KeyValueTextInputFormat.class);
        job_two.setOutputFormatClass(TextOutputFormat.class);
         
        // The output of previous job set as input of the next
        FileInputFormat.addInputPath(job_two, new Path(temp));
        FileOutputFormat.setOutputPath(job_two, new Path(output));
         
        // Run the job
 		System.exit(job_two.waitForCompletion(true) ? 0 : 1);
		
	}
	
	public static class mapOne extends Mapper<Text, Text, Text, Text> {

		public void map(Text key, Text value, Context context) throws IOException, InterruptedException {
			context.write(key, value);
		}
	}
	
	public static class reduceOne extends Reducer<Text, Text, Text, Text> {
			
		
				public Text  s=new Text();
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			for(Text v:values)
			{
				if(key.toString().length()!=15 && v.toString().length()!=40)
				{
					return;
				}
				context.write(key, v);
			}
        }
	} 
	
	// Compare each input key with the boundaries we get from the first round
	// And add the partitioner information in the end of values
	public static class mapTwo extends Mapper<Text, Text, Text, Text> {
		public void map(Text key, Text value, Context context) throws IOException, InterruptedException {
			
			if(!isValid(key,value)) {
				return;
			}
			
				
			String partition=dPartition(key.toString());
			context.write(key, new Text(value.toString()+ ";"+partition));
		}
			
			public boolean isValid(Text key,Text value)
			{
				return key.toString().length()==15 && value.toString().length()==40;
			}
			
			public String dPartition(String key)
			{
					String[]partition = {"A","F","J","O","T","X","d","i","p"};
					
					for(int i=0;i<partition.length;i++)
					{
						if(key.compareTo(partition[i])<=0)
						{
								return String.valueOf(i);
						}
					}
					return String.valueOf(partition.length);
			}
	}
			
			
	
		
	
	public static class reduceTwo extends Reducer<Text, Text, Text, Text> {
     	public void reduce(Text key, Iterable<Text> values, Context context)throws IOException, InterruptedException {
			for(Text v:values)
			{
				String[] tempo=v.toString().split(";");
				
				context.write(key, new Text(tempo[0]));
					
			}
     	}
	 }
	
	// Extract the partitioner information from the input values, which decides the destination of data
	public static class MyPartitioner extends Partitioner<Text,Text>{
		
	   public int getPartition(Text key, Text value, int numReduceTasks){
		   
		   String[] desTmp = value.toString().split(";");
		   return Integer.parseInt(desTmp[1]);
		   
	   }
	}
}
