import java.util.ArrayList;  
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
    	
    	boolean[] visit = new boolean[adj.length];
    	return dfs(adj, x, y, visit);
    	
    }
    
    private static int dfs(ArrayList<Integer>[] adj, int source, int end, boolean[] visit){
    	
    	if ( source == end)
    			return 1;
    	
    	visit[source] = true;
    	//Recursively explore all unvisited(adjacent) verticies
    	
    	for (int neighbour: adj[source]){
    		if(!visit[neighbour])
    			if( dfs(adj, neighbour, end, visit) == 1) return 1;
    	}
    	visit[source] = false;
    	return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

