import java.util.*;
class Solution {
    class Pair implements Comparable<Pair>
    {
        int value;
        int bit;
        int posn;
        Pair(int v, int b,int p)
        {
            this.value = v;
            this.bit = b;
            this.posn = p;
        }
        @Override
        public int compareTo(Pair p)
        {
            if(p.bit != this.bit)  return p.bit - this.bit;
            return this.posn - p.posn;
        }
    }
    int countbit(int n)
    {
        int cnt =0;
        while(n>0)
        {
            n = n& (n-1);
            cnt++;
        }
        return cnt;
    }
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // code here
        
        Pair[] store = new Pair[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            store[i]= new Pair(arr[i],countbit(arr[i]),i);
        }
        Arrays.sort(store);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            ans.add(store[i].value);
        }
        return ans;
        
    }
}