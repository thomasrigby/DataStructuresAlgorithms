package SpanningTree;

import CITS2200.Graph;
import CITS2200.Path;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * @author Thomas Rigby
 */

public class PathImp implements Path {

  /** 
   * @param graph
   * @return int amount
   */
  public int getMinSpanningTree(Graph graph) {
   //initialise amount and vertexT
   //set vertexCount to equal the number of vertices in graph
    int amount = 0;
    int vertexT = 0;
    int vertexCount = graph.getNumberOfVertices();
    int w [][] = graph.getEdgeMatrix();
    boolean [] s = new boolean[vertexCount];
    //create new PriorityQueue
    PriorityQueue<Edge> Q = new PriorityQueue<Edge>(vertexCount);
    Q.add(new Edge(0,0));

    while(!Q.isEmpty()){
        Edge e = Q.remove();
        if(s[e.vertex]== false) {
            s[e.vertex] = true;
            vertexT++;
            amount += e.weight;
    //iterate through vertexCount and add new edge to PriorityQueue
            for(int i =0; i<vertexCount; i++) {
                if(w[e.vertex][i] != 0 && s[i] ==false){
                    Q.add(new Edge(i, w[e.vertex][i]));
                }
            }
        }
    }
    if(Q.isEmpty() && vertexT < vertexCount){
        return -1;
    }
    return amount;
  }

  
  /** 
   * @param graph
   * @param source
   * @return int[]vertexP
   */
  public int[] getShortestPaths(Graph graph, int source) {
  
    int vertexCount = graph.getNumberOfVertices();

    int vertexP[] = new int[vertexCount];
    Arrays.fill(vertexP, -1);
    vertexP[source] = 0;

    int w[][] = graph.getEdgeMatrix();
    boolean[]s = new boolean[vertexCount];

    PriorityQueue<Edge> Q = new PriorityQueue<Edge>(vertexCount);
		Q.add(new Edge(source,0));
		
		while(!Q.isEmpty()) {
			Edge e = Q.remove();
			if(s[e.vertex] == false) {
				s[e.vertex] = true;
				vertexP[e.vertex] = e.weight;
				
				for(int i = 0; i < vertexCount; i++) {
					if(w[e.vertex][i] != 0 && s[i] == false){
						 
						Q.add(new Edge(i, graph.getWeight(e.vertex, i) + e.weight));
					}
				}
			}
		}
		return vertexP;
	}
    /**
     * Subclass that creates a type Edge to be used by the PriorityQueue
     */
    private class Edge implements Comparable<Edge>{
		public int vertex;
		public int weight;
	/**
	 * @param e 
	 * @param w
	 */
		public Edge(int e, int w){
			vertex = e;
			weight = w;
		}
		
		/**
		 * Compares the weights of specified edges
         * Sort priority queue to have edges of the lowest weight at the head of the queue.
		 */
		public int compareTo(Edge present) {
			return Integer.compare(this.weight, present.weight);
		}
	}
  }



