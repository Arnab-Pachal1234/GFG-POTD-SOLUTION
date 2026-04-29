class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int totalones =0;
        for(int el : arr)
        {
            totalones+=el;
        }
        if(totalones==0) return -1;
        int n = arr.length;
        int preones[] = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            preones[i]=preones[i-1]+arr[i-1];
        }
        int min = totalones;
        int i=0,j=totalones;
        while(j<=n)
        {
            min = Math.min(min,totalones-(preones[j]-preones[i]));
            j++;
            i++;
        }
        return min;
    }
}