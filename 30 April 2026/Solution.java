class Solution {
    int a[];
    public boolean helper(int i)
    {
        if(i>=a.length) return true;
        int left = 2*i+1;
        int right = 2*i+2;
        if((left<a.length && a[left]>a[i])) return false;
         if((right<a.length && a[right]>a[i])) return false;
         boolean checkleft = helper(left);
         boolean checkright = helper(right);
         return checkleft && checkright;
        
    }
    public boolean isMaxHeap(int[] arr) {
        // code here
        this.a = arr;
        return helper(0);
        
    }
}