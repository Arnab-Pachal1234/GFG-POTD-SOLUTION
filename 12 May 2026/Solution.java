class Solution {
  
    long tree[];
    int arr[];
    long build(int node,int left,int right)
    {
        if(left == right ) return tree[node]=arr[left];
        int mid = left + (right-left)/2;
        int leftchild = 2*node+1;
        int rightchild = 2*node+2;
        long lcmleft = build(leftchild,left,mid);
        long lcmright = build(rightchild,mid+1,right);
        return tree[node]=lcm(lcmleft,lcmright);
    }
        void  update(int node ,int left,int right,int idx,int val)
        {
            if(left == right && idx == left) {tree[node]=val;return;}
            int mid = left + (right-left)/2;
            if(idx<=mid)
            { update(2*node+1,left,mid,idx,val);}
            else{ update(2*node+2,mid+1,right,idx,val);}
            tree[node] = lcm(tree[2*node+1],tree[2*node+2]);
        }
    long  query(int node ,int left,int right,int L,int R)
        {
            if( R < left || L > right ) return 1;   
            if( L<=left && R >=right ) return tree[node];
            int mid = left + (right-left)/2;
            long leftchild = query(2*node+1,left,mid,L,R);
            long rightchild = query(2*node+2,mid+1,right,L,R);
            return lcm(leftchild,rightchild) ;

        }


    private long gcd(long a,long b)
    {
        if(a==0) return b;
        if(b==0) return a;
        if(a>b)
        {
            return gcd(a%b,b);
        }
        else
        {
            return gcd(a,b%a);
        }
    }
    private long lcm(long a,long b)
    {
        if(a==0 || b==0) return 0;
        return (a/gcd(a,b))*b;
    }
    
    
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        int n = arr.length;
     tree = new long[4*n];
     this.arr = arr;
     ArrayList<Long> store = new ArrayList<>();
     build(0,0,n-1);
     for(int q[] : queries)
     {
         int type = q[0];
         if(type==1)
         {
             update(0,0,n-1,q[1],q[2]);
         }
         else
         {
             long ans = query(0,0,n-1,q[1],q[2]);
             store.add(ans);
         }
     }
     return store;
    }
    
}