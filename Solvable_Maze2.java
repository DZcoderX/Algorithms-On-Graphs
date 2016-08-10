Part 2 of Solvable Maze
(Please refer to "README")

Input: A graph is given in the standard format.

Output: Output the number of connected components with undirected graphs.

If a maze have 5 sections but only 4 are connected to one another, the algorithm below will output 4. 

The algorithm below can compute up to 1000 nodes of a maze and 1000 paths between the nodes well under 1.5 seconds. 

Sample: 
Input:
4 2
1 2
3 2
Output:
2
Explanation:
There are two connected components here: {1; 2; 3} and {4}.
Visualization: https://i.gyazo.com/1b6b3d9ffe9b960ea6991c3eeed08c30.png
===========================================================================================================
import java.util.ArrayList;
import java.util.Scanner;

public class Solvable_Maze2 {
	private static int numberOfComponents(ArrayList<Integer>[] adj) {
        /**Connected Components of undirected graph.*/
        boolean[] visited = new boolean[adj.length];
        int result = 0;
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]){
            	dfs(i, adj, visited);
            	//The region of that specific CC have been explored
            	//Moving on to next region (new CC)
            	result++;
            }
        }
        return result;
    }
    
    private static void dfs(int vertex, ArrayList<Integer>[] adj, boolean[] visited) {
        // All connected vertices have same count of CC.
    	//For further explaination of the following code, refer to the Solvable_Maze file.
    	visited[vertex] = true;
        
    	for (int neighbor : adj[vertex]) {
    		if (! visited[neighbor]) 
    			dfs(neighbor, adj, visited);
        }
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
        System.out.println(numberOfComponents(adj));
    }
}

