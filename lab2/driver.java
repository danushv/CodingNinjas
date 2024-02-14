
import java.io.*;
import java.util.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Driver {

  public static void main(String[] args) throws Exception {
    
    String input = "/lab2_2/shakespeare";
    String temp = "/lab2_2/temp2";
    String output = "/lab2_2/output2";

    
    int reduce_tasks = 2;

    Configuration conf = new Configuration();

    // Create job for round 1
    Job job_one = new Job(conf, "Bigrams Program Round One");

    // Attach the job to this Driver
    job_one.setJarByClass(Driver.class);

    // Fix the number of reduce tasks to run
    // If not provided, the system decides on its own
    job_one.setNumReduceTasks(reduce_tasks);

    // The datatype of the mapper output Key, Value
    //job_one.setMapOutputKeyClass(Text.class);
    //job_one.setMapOutputValueClass(IntWritable.class);

    // The datatype of the reducer output Key, Value
    job_one.setOutputKeyClass(Text.class);
    job_one.setOutputValueClass(IntWritable.class);

    // The class that provides the map method
    job_one.setMapperClass(Map_One.class);

    // The class that provides the reduce method
    job_one.setReducerClass(Reduce_One.class);

    // Decides how the input will be split
    // We are using TextInputFormat which splits the data line by line
    // This means wach map method recieves one line as an input
    job_one.setInputFormatClass(TextInputFormat.class);

    // Decides the Output Format
    job_one.setOutputFormatClass(TextOutputFormat.class);

    // The input HDFS path for this job
    // The path can be a directory containing several files
    // You can add multiple input paths including multiple directories
    FileInputFormat.addInputPath(job_one, new Path(input));
    // FileInputFormat.addInputPath(job_one, new Path(another_input_path)); // This is legal

    // The output HDFS path for this job
    // The output path must be one and only one
    // This must not be shared with other running jobs in the system
    FileOutputFormat.setOutputPath(job_one, new Path(temp));
    // FileOutputFormat.setOutputPath(job_one, new Path(another_output_path)); // This is not allowed

    // Run the job
    job_one.waitForCompletion(true);

    // Create job for round 2
    // The output of the previous job can be passed as the input to the next
    // The steps are as in job 1

    Job job_two = new Job(conf, "Bigrams Program Round Two");
    job_two.setJarByClass(Driver.class);
    job_two.setNumReduceTasks(reduce_tasks);

    //job_two.setMapOutputKeyClass(Text.class);
    //job_two.setMapOutputValueClass(IntWritable.class);

    // Should be match with the output datatype of mapper and reducer
    job_two.setOutputKeyClass(Text.class);
    //Inwritable
    job_two.setOutputValueClass(Text.class);

    // If required the same Map / Reduce classes can also be used
    // Will depend on logic if separate Map / Reduce classes are needed
    // Here we show separate ones
    job_two.setMapperClass(Map_Two.class);
    job_two.setReducerClass(Reduce_Two.class);

    job_two.setInputFormatClass(TextInputFormat.class);
    job_two.setOutputFormatClass(TextOutputFormat.class);

    // The output of previous job set as input of the next
    FileInputFormat.addInputPath(job_two, new Path(temp));
    FileOutputFormat.setOutputPath(job_two, new Path(output));

    // Run the job
    job_two.waitForCompletion(true);
  }

  public static class Map_One
    extends Mapper<LongWritable, Text, Text, IntWritable> {

    //constants used to avoid extraneous object construction
    private final IntWritable one = new IntWritable(1);
    private final Text bigram = new Text();

    public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

      String line = value.toString();
      StringTokenizer tokens = new StringTokenizer(line);
      String previous = null;
      while (tokens.hasMoreTokens()) {
        String changer = tokens.nextToken();

        
        changer = changer.toLowerCase();
        changer = changer.replaceAll("[^a-z0-9]", " ");
        changer = changer.replaceAll("\\s+", " ");
        String words[] = changer.split(" ");

        for (String word : words) {
          if (
            previous == null || previous.equals(".") ||word.equals(".") ||previous.equals("") ||word.equals("")
        ) {} else {
            bigram.set(previous + " " + word);
            context.write(bigram, one);
          }
          previous = word;
        }
      } 
    }
  }
  public static class Reduce_One
    extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
      int totalsum = 0;
      for (IntWritable value : values) {totalsum =totalsum+ value.get();}
      context.write(key, new IntWritable(totalsum));
    }
  }

  public static class Map_Two extends Mapper<LongWritable, Text, Text, Text> {

    private final Text tkey = new Text("key");

    public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
      context.write(tkey, value);
    }
  }


  public static class Reduce_Two
    extends Reducer<Text, Text, Text, IntWritable> {

    public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
      
      Map<String, Integer> highest = new HashMap<String, Integer>();

      for (Text t : values) {
        String[] s = t.toString().split("\t");
        String bigram = s[0];
        int value = Integer.parseInt(s[1]);

        if (highest.size() < 10) {
          
        	highest.put(bigram, value);
        } else {
          Map.Entry<String, Integer> minimum = null;
          for (Map.Entry<String, Integer> e : highest.entrySet()) {
            if (minimum == null) {
              minimum = e;
            } else {
              if (e.getValue() < minimum.getValue()) {
                minimum = e;}} }

          if (value > minimum.getValue()) {
        	  highest.remove(minimum.getKey());
        	  highest.put(bigram, value);}}}

      for (Map.Entry<String, Integer> e : highest.entrySet()) {
        context.write(new Text(e.getKey()), new IntWritable(e.getValue()));
      }
    }
  }
}
