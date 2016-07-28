Give any undirected graph and two distinct vertices u and v, and the program will check if there is a path between u and v.

Input: (Refer to "README") 
First line: n vertices and m edges.
Next lines are two vertices. Last line: type the start and finish vertices. 
Output:  1 if there is a path between u and v and 0 otherwise.

Sample: 

Input: 
4 4
1 2
3 2
4 3
1 4
1 4

Output: 1

Visualization: https://i.gyazo.com/ff930a8e23ee2c6b0aa8710d2f9599bd.png

There are two paths between vertices 1 and 4: 1-4 and 1-2-3-4.




==========================================================================================================================
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

