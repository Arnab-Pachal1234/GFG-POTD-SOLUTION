class Solution {
    boolean isPal(String s)
    {
        int l=0,r=s.length()-1;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean palindromePair(String[] arr) {
    //   int n = arr.length;
    //   for(int i=0;i<n;i++)
    //   {
    //       for(int j=0;j<n;j++)
    //       { 
    //           if(i==j) continue;
    //           if(isPal(arr[i]+arr[j]))
    //           {
    //               return true;
    //           }
    //       }
    //   }
    //   return false;
    int n = arr.length;
    
    HashMap<String,Integer> map = new HashMap<>();
    for(int i=0;i<n;i++)
    {
        map.put(new StringBuilder(arr[i]).reverse().toString(),i);
    }
    for(int i=0;i<n;i++)
    {
        String s= arr[i];
        int k = s.length();
        for(int j=0;j<k;j++)
        {
            String u = s.substring(0,j);
            String v = s.substring(j,k);
            if(isPal(u) && map.containsKey(v) && map.get(v)!=i)
            {
                return true;
            }
            if (isPal(v) && map.containsKey(u) && map.get(u)!=i)
            {
                return true;
            }
        }
    }
    return false;
    }
}