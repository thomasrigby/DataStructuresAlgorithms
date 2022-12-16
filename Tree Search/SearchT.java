

import CITS2200.Graph;
import CITS2200.Search;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class SearchT implements Search {

    //make a list to pass along int[] from BFS
	private final static LinkedList<int[]> result = new LinkedList<int[]>();

	
    /** 
     * @param g
     * @param startVertex
     * @return int[]
     */
    public int[] getConnectedTree(Graph g, int startVertex) {
		prior(g,startVertex);
		return result.get(0);
	}

	
	
    /** 
     * @param g
     * @param startVertex
     * @return int[]
     */
    public int[] getDistances(Graph g, int startVertex) {
		prior(g,startVertex);
		return result.get(1);
		}

     
     /** 
      * @param g
      * @param startVertex
      */
     public void prior(Graph g, int startVertex) {
            
            int[][] graphAdj = g.getEdgeMatrix();
            int numV = g.getNumberOfVertices();
            int[] colour = new int[numV];  //white = 0 not found, grey = 1 found, black = 2 processed      
            colour[startVertex] = 1;
            int[] parentArray = new int[numV];	
            Arrays.fill(parentArray, -1);
            int[] distance = new int[numV];
            Arrays.fill(distance,-1);
            Queue<Integer> verticesTemp = new LinkedList<Integer>();
            verticesTemp.add(startVertex);
            distance[startVertex] = 0;
            while(!verticesTemp.isEmpty()){
                int temp = verticesTemp.poll();
                for(int i = 0; i < numV; ++i){
                    if (graphAdj[temp][i] > 0 && colour[i] < 1){
                        distance[i] = distance[temp] + 1;
                        parentArray[i] = temp;
                        colour[i] = 1;
                        verticesTemp.add(i);
                    }
                }
            }
        result.add(0,parentArray);
        result.add(1,distance);
        }
    
       
        
        /** 
         * @param g
         * @param startVertex
         * @return int[][]
         */
        public int[][] getTimes(Graph g, int startVertex) {
            int vertex = g.getNumberOfVertices();
            int[][] startFin = new int[vertex][2];            
            int[] colours = new int[vertex];          
            int timer = 0;
            //Start DFS
            for(int i = 0; i<vertex; ++i){
                if(colours[i] < 1){
                    DFS(g, startVertex, colours, startFin, timer);
                }
            }
            return startFin;
        }
        
        /** 
         * @param g
         * @param currentVertex
         * @param int[]colour
         * @param int[][]startFin
         * @param timer
         */
        private void DFS(Graph g, int currentVertex, int[]colour, int[][]startFin, int timer){
            int vertices = g.getNumberOfVertices();
           
            colour[currentVertex] = 1;
          
            int[][] adjacencyMatrix = g.getEdgeMatrix();
            
            startFin[currentVertex][0] = ++timer;
            for(int i = 0; i < vertices; ++i){
                if(adjacencyMatrix[currentVertex][i] > 0 && colour[i] < 1){
                    DFS(g, i, colour, startFin, timer);
                }
            }
            colour[currentVertex] = 2;
            startFin[currentVertex][1] = ++timer;
        }
        
    }


