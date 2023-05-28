Given an array ‘ARR’ of size ‘N’. You are also given two indices ‘L’ and ‘R’.
Your task is to reverse the ‘ARR’ from index ‘L’ to ‘R’ inclusive.

   while(l<=r)
        {
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
        return arr;
    }
