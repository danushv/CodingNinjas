public class Solution{  

    public static int findUnique(int[] arr){
		//Your code goes here
    int n=arr.length;
    int unique=-1;
    for (int i=0;i<n;i++)
    {
      for(int j=i+1;j<n;j++)
      {
        if(arr[i]==arr[j])
        {
          arr[i]=0;
          arr[j]=0;
        }
      }
    }
      for (int i=0;i<n;i++){
        if(arr[i]!=0){
          unique=arr[i];
        }
      }
      return unique;
    }
}
