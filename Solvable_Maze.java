Give any undirected graph and two distinct vertices u and v, and the program will check if there is a path between u and v.

Input: (Refer to "README") 
First line: n vertices and m edges.
Next lines are two vertices. Last line: type the start and finish vertices. 
Output:  1 if there is a path between u and v and 0 otherwise.

Under 1.5 seconds, the following algorithm can compute up to 1000 nodes of a maze and the paths between the nodes.

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


Input:
4 4
1 2
4 1
2 3
3 1
2 4
Output:
2
Explanation:
There is a unique shortest path between vertices 2 and 4 in this graph: 2 − 1 − 4.

Visualization:https://i.gyazo.com/b293bea5eb9e43f8ac2875f2ba71dafc.png




==========================================================================================================================
import java.util.ArrayList;  
import java.util.Scanner;
//Using DFS (Decomposition First Search)
public class Solvable_Maze {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //Boolean array is used to determine if nodes are visited or not
    	boolean[] visit = new boolean[adj.length];
    	//Setting x as the starting point
    	return dfs(adj, x, y, visit);
    }
    private static int dfs(ArrayList<Integer>[] adj, int source, int end, boolean[] visit){
    	if (source == end)
    			return 1;
    	//Marking source (previously named x) as true (visited)
    	visit[source] = true;
    	//Recursively explore all unvisited but adjacent verticies
    	for (int neighbour: adj[source]){
    		if(!visit[neighbour])
    			if( dfs(adj, neighbour, end, visit) == 1) return 1;
    	}
    	
    	//Since the array visited is initialized with false, no need to set "visit[source] = false;"
    	//Also means there is not path between source and end
    	
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

