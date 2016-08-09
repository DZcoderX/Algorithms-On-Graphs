import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinNumPaths_BreadthFirstSearch {
	// s = source, the origin.
	// adj = graph in ArrayList form
	// t = the destination
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
    	
    	int [] distance = new int[adj.length];
    	//Initializing all distances with an estimation of infinity (Aka max_value for coding)
    	for (int i = 0; i < distance.length; i ++){
    		distance[i] = Integer.MAX_VALUE;
    	}
    	
    	distance[s] = 0;
    	//Need to use a queue to deliver the principle of first in, first out
    	Queue<Integer> queue = new LinkedList<>();
    	//Symbolizes that node S was already discovered. 
    	queue.offer(s);
    	//All the discovered nodes are those which are in the queue. 
    	while (!queue.isEmpty()){
    		//Using the method Dequeue
    		//Starting node is set to u.
    		int u = queue.poll();
    		//Processing it now meaning that we trigger all the edges outgoing from that node.
    		for (int v : adj[u]){
    		//This process traverses all the edges which have the starting node of u and another node as the end point
    			if (distance[v] == Integer.MAX_VALUE){
    				//If the value of distance[v] is max_value, it means this node has NOT been discovered yet.
    				//Using the method Enqueue and adding it to the end of queue
    				queue.offer(v);
    				//Discovering this node, the distance becomes a finite number and is just the value of of the starting node + 1
    				distance[v] = distance[u] + 1;
    			}
    		}
    		//Do not do anything if the node has been discovered already.
    	}
    	
   
        return distance[t] == Integer.MAX_VALUE ? -1 : distance[t];
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
        System.out.println(distance(adj, x, y));
    }
}

