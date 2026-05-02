class Solution {
    public int findPosition(int n) {
        // code here
        if((n&(n-1))!=0) return -1;
        
        int cnt =1;
        while(n>0)
        {
         if((n&1)==1) return cnt;
         n>>=1;
         cnt++;
        }
        return cnt ;
        
    }
}