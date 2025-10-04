import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class detect_cycle {
    public boolean dfs(int node,int parent,List<Integer>[] adj,boolean vis[])
    {
        vis[node]=true;
        for(Integer it:adj[node])
        {
            if(!vis[it])
            {
                if(dfs(it,node,adj,vis))
                return true;
            }
            else if(parent!=it)
            {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
       
       boolean vis[]=new boolean[V]; 
       for(int i=0;i<V;i++)
       {
        if(!vis[i])
        {
            if(dfs(i,-1,adj,vis)==true)
            return true;
        }
       }
       return false;
    }
     public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));
        
        /* Creating an instance of 
        Solution class */
        detect_cycle sol = new detect_cycle();
        
        /* Function call to detect 
        cycle in given graph. */
        boolean ans = sol.isCycle(V, adj);
        
        // Output
        if (ans) 
            System.out.println("The given graph contains a cycle.");
        else 
            System.out.println("The given graph does not contain a cycle.");
    }
}
