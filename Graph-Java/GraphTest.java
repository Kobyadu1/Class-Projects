package TSP;

import java.util.ArrayList;

public class GraphTest {
 static Graph g1 = new Graph();
 static Graph g2 = new Graph();
 static Graph g3 = new Graph();
static Graph g4 = new Graph();
static Graph g5 = new Graph();
static int currentSize = 9999;
 public static ArrayList<ArrayList<GraphNode>>paths = new ArrayList<>();
 
 public static void main(String[] args) {
  buildGraphs(5,g1);
  buildGraphs(10,g2);
  buildGraphs(15,g3);
  buildGraphs(20,g4);
  buildGraphs(25,g5);
  //g1.displayGraph();
  //g2.displayGraph();
  //g3.displayGraph();
  //g4.displayGraph();
  //g5.displayGraph();
   Graph test = new Graph();
   buildGraphs(12,test);
  
  Long startTime = System.nanoTime();
  pathPermutations(new ArrayList<>(),test.returnAsList());
  Long endTime = System.nanoTime();
  System.out.println("The shortest path is "+paths.get(0)+"\nThis program took "+(endTime-startTime)/1000000.0+" ms");
  }
  private static void buildGraphs(int groupSize, Graph g) {
    for(int k = 1;k<=groupSize;k++) {
         g.addNode(1, ""+k);
    }
    for(int i = 1;i<=groupSize;i++) {
      for(int j = 1;j<=groupSize;j++) {
        if(j!=i) {
          g.addEdge(""+i, ""+j, 1, "");
        }
      }
    }
  }
  
  public static void pathPermutations(ArrayList<GraphNode> path, ArrayList<GraphNode> nodesNotInPath)
  {
    if(!nodesNotInPath.isEmpty()) {
      for(int i = 0; i<nodesNotInPath.size(); i++) {
        GraphNode justRemoved = nodesNotInPath.remove(0);
        ArrayList<GraphNode> newRoute = (ArrayList<GraphNode>) path.clone();
        newRoute.add(justRemoved);
        pathPermutations(newRoute, nodesNotInPath);
        nodesNotInPath.add(justRemoved);
       }
     }
     else {
      if(path.size()<currentSize) {
        currentSize = path.size();
        paths.add(0, path);
    }
   }
  }
}
