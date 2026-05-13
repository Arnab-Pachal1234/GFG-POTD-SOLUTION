class Solution {
   void  dfs(int i,int vis[],List<List<Integer>>adj)
    { vis[i]=1;
 for(Integer neigh : adj.get(i)) {
    if(vis[neigh]==0) dfs(neigh,vis,adj);
    }
}
    public int findMotherVertex(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int e[] : edges)
        {
            adj.get(e[0]).add(e[1]);
        }
        int vis[] = new int[V];
        int mother =-1;
        for ( int i=0;i<V;i++)
        {
            if(vis[i]==0) {dfs(i,vis,adj);mother =i;}
        }
        Arrays.fill(vis,0) ;
        dfs(mother,vis,adj);
        for(int i=0;i<V;i++)
            {
            if(vis[i]==0) {return -1;}
            
            }
            return mother;

    }
}