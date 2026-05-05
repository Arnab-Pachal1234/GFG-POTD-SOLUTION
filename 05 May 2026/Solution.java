class Solution {
    public long sumXOR(int[] arr) {
        // code here
        int n = arr.length;
        int [] suffbit[] = new int[n+1][21];
        for(int i=n-1;i>=0;i--)
        {
            int el = arr[i];
            for(int j=0;j<=20;j++)
            {
                int  num = el & (1<<j);
                if(num>0)
                {
                    suffbit[i][j]=suffbit[i+1][j]+1;
                }
                else
                {
                    suffbit[i][j]=suffbit[i+1][j];
                }
            }
        }
        long sum =0;
        for(int i=0;i<n;i++)
        {
            int el = arr[i];
             for(int j=0;j<=20;j++)
            {
                int  num = el & (1<<j);
                if(num>0)
                {
                    sum += (1L<<j)*(n-i-1-suffbit[i+1][j]);
                }
                else
                {
                    sum+= (1L<<j)*(suffbit[i+1][j]);
                }
            }
            
        }
        return sum;
    //     long sum = 0;
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         for(int j=i+1;j<arr.length;j++)
    //         {
    //             int xor = arr[i] ^ arr[j];
    //             sum += xor;
    //         }
    //     }
    //     return sum;
    // }
}
}
/*
1 1 1 --> 7
0 1 1 --> 3
1 0 1--> 5
*/