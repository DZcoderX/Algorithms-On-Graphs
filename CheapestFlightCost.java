import java.util.*; 
import java.io.*;

public class CheapestFlightCost {
	public static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t){
		int n = adj.length;
		//Using array as the data structure but a priority queue will also work 
		int[] dist = new int[n];
		int[] prev = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			//Setting distance value of each edge to infinity 
            dist[i] = Integer.MAX_VALUE;
            //Setting the prev value to "null"
            prev[i] = -1;
        }
		//Setting the source as distance 0
		dist[s] = 0;
		
		for (int j = 0; j < n; j ++){
			//Taking the node with the minimum distance value to the current node 
			int u = extractMin(dist, visited);
			if (u == -1) 
				continue;
			//Setting the node that was taken out as visited
			visited[u] = true;
			
			for (int i = 0; i < adj[u].size(); i ++){
				//v stands for value, w stands for the weight since it's a weighted graph
				int v = adj[u].get(i), w = cost[u].get(i);
				/*Edge Relaxation 
				dist[v] is the upper bound on the actual distance from S to v
				The procedure just checks whether going from S to v through u 
				improves the current value of dist[v] or not */				
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					prev[v] = u;
				}
			}
			
		}
		return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];
	}
	
	/* This procedure will also extract the minimumn distance
	 * value node. The reason is after each iteration, the*/
	public static int extractMin(int[] dist, boolean[] visited){
		int minDist = Integer.MAX_VALUE, minVertex = -1;
		
		for ( int v = 0; v <dist.length; v ++){
			//If the node is already visited, skip the current iteration
			if (visited[v])
				continue;
			/*The minimum value of a vertex is set to the current
			 *v if the distance value from s to v is less the 
			 *current distance*/
			if (dist[v] < minDist)
				minVertex = v;
			/*Setting the minimum distance as the smallest 
			 *integer between the distance from s to v and the
			 *current minimum distance*/
			minDist = Math.min(minDist, dist[v]);
		}
		//Vertex aka Node
		return minVertex;
		
	}
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
        
        scanner.close();
    }

}