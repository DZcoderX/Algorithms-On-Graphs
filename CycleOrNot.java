/*

This program determines whether a given directed graph contains a cycle or not.

In less than 1.5 seconds, the following algorithm can compute 1000 nodes of a graph and 1000 paths between the nodes.

A fabulous use for this algorithm can determine if a student has all the pre-requisities courses to take another course within
a school system. 
For ex: 
Bob wants to take a "Learn how to make cake" course but the school only offer that course to student who completed "Learn about milk" course 
and "Learn about Eggs" Course. This algorithm may be used to determine if Bob is qualified or not.


Sample:

Input:
4 4
1 2
4 1
2 3
3 1
Output:
1
Explanation: This graph contains a cycle: 3 → 1 → 2 → 3.
Visualization: https://i.gyazo.com/933c85fefeae1cc4076ecfafb96cfad1.png

Input:
5 7
1 2
2 3
1 3
3 4
1 4
2 5
3 5
4
Output:
0
Explanation:
There is no cycle in this graph. This can be seen, for example, by noting that all edges in this graph
go from a vertex with a smaller number to a vertex with a larger number.

Visualization: https://i.gyazo.com/a553262170496732088be8ca031533d8.png


*/



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

