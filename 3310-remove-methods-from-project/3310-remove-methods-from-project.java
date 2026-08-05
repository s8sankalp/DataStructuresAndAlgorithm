class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++)
        {
            int u=invocations[i][0];
            int v=invocations[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis=new boolean[n];
        dfs(k,vis,adj);
       for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!vis[u] && vis[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                ans.add(i);
            }
        }
    
        return ans;

    }
    public void dfs(int node,boolean vis[],List<List<Integer>> adj)
    {
        vis[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,vis,adj);
            }
        }
    }
}