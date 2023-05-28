You have been given an integer array/list(ARR) of size N. It has been sorted(in increasing order) and then rotated by some number 'K' (K is greater than 0) in the right hand direction.
Your task is to write a function that returns the value of 'K', that means, the index from which the array/list has been rotated.  

int n=arr.length;
        int min=Integer.MAX_VALUE;
        int pos=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
                pos=i;

            }
        }
        return pos;
    }
