import java.util.ArrayList; 
import java.util.Scanner;

public class CycleOrNot {
	//Based on using Directed Graphs
    private static int acyclic(ArrayList<Integer>[] adj) {
    	
    	int n = adj.length; 
    	//Similar algorithm with Solvable_Maze 
    	
    	//Initializing the following boolean array to keep track of (un)visited nodes
    	boolean[] visited = new boolean[n];
    	//stack1 array is used to contribute to determine whether there is a cycle or not
    	boolean[] stack1 = new boolean[n];
    	for (int v = 0; v < n; v++){
    		if ( !visited[v]){
    			if (dfs(v,adj, visited, stack1) == 1) return 1;
    		}
    	}
      
        return 0;
    }
    
    private static int dfs(int vertex, ArrayList<Integer>[] adj, boolean[] visited, boolean[] stack1){
    	//Setting the node as explored
    	visited[vertex] = true;
    	//All adjacent nodes of the source node (vertex) have not been explored 
    	//The source node has the potential to be part of a cycle
    	stack1[vertex] = true;
    	
    	for (int w : adj[vertex]){
    		//Recursively explore until all adjacent nodes have been visited
    		if (!visited[w]){
    			if(dfs(w, adj, visited, stack1)==1) return 1;
    		}
    		//If node is visited and on stack then cycle has been found
    		if (visited[w] && stack1[w]) 
    			return 1;
    	}
    	//All adjacent nodes have been explored and thus, pop the source node from the stack
    	stack1[vertex] = false;
    	
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
        }
        System.out.println(acyclic(adj));
    }
}

