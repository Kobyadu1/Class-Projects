package TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


//Graph implementation by Koby Adu-Bonnah; December 22nd 2018
public class Graph {
  
  //Declarations
  public HashMap<GraphNode, ArrayList<Edge>> g;
  
  public Graph() {
	g = new HashMap<GraphNode,ArrayList<Edge>>();
  }
  
  public Graph(HashMap<GraphNode,ArrayList<Edge>>g) {
	this.g=g;
  }
  
  public void addNode(GraphNode nodeToAdd) {
	g.put(nodeToAdd, new ArrayList<Edge>());
  }
  
  public void addNode(double size,ArrayList<GraphNode>connectingNodes,String name) {
	g.put(new GraphNode(size,connectingNodes,name), new ArrayList<Edge>());
  }
  
  public void addNode(double size,String name) {
	g.put(new GraphNode(size,new ArrayList<GraphNode>(),name), new ArrayList<Edge>());
  }
  
  public void removeNode(GraphNode graphNodeToRemove) {
	for(GraphNode gn:g.keySet()) {
	  for(Edge e:g.get(gn)) {
		if(e.getEnd().equals(graphNodeToRemove)) {
		  Edge ghostEdge = e;
		  g.get(gn).remove(ghostEdge);
		  gn.removeConnectingNode(graphNodeToRemove);
		  break;
		}
	  }
	}
	g.remove(graphNodeToRemove);
  }
  
  public void removeNode(String graphNodeName) {
	GraphNode temp = null;
	
	for(GraphNode gn:g.keySet()) {
	  if(gn.getName().equals(graphNodeName)) {
		temp = gn;
	  }
	}
	removeNode(temp);
  }
  
  public GraphNode getNode(String graphNodeName) {
	GraphNode temp = null;
	
	for(GraphNode gn:g.keySet()) {
	  if(gn.getName().equals(graphNodeName)) {
		temp = gn;
	  }
	}
	return temp;
  }
  
  
  public void addEdge(GraphNode start,GraphNode end,double length,String name) {
	g.get(start).add(new Edge(start,end,length,name));
	start.addConnectingNode(end);
  }
  
  public void addEdge(String nodeStartName,String nodeEndName,double length,String name) {
	GraphNode tempStart = null;
	GraphNode tempEnd = null;
	
	for(GraphNode gn:g.keySet()) {
	  if(gn.getName().equals(nodeStartName)) {
		tempStart = gn;
	  }
	  if(gn.getName().equals(nodeEndName)) {
		tempEnd = gn;
		}
	  if(tempStart!=null&&tempEnd!=null) {
		break;
	  }
	}	
	addEdge(tempStart,tempEnd,length,name);
  }
  
  public void removeEdge(Edge e) {
	for(Edge tempEdge:g.get(e.getStart())) {
	  if(tempEdge.getEnd().equals(e.getEnd())) {
		Edge ghostEdge = tempEdge;
		g.get(e.getStart()).remove(ghostEdge);
		e.getStart().removeConnectingNode(e.getEnd());
		break;
	  }	
	}
  }
  
  public void removeEdge(GraphNode start,GraphNode end) {
	for(Edge tempEdge:g.get(start)) {
	  if(tempEdge.getEnd().equals(end)) {
		Edge ghostEdge = tempEdge;
		g.get(start).remove(ghostEdge);
		start.removeConnectingNode(end);
		break;
	  }	
	}
  }
  public ArrayList<GraphNode> returnAsList() {
    ArrayList<GraphNode> keys = new ArrayList<GraphNode>(g.keySet());
    keys.sort(new myComparator());
    return keys;
  }
  public void displayGraph() {
    ArrayList<GraphNode> keys = new ArrayList<GraphNode>(g.keySet());
    keys.sort(new myComparator());
    System.out.println(keys);
    
    for(GraphNode gn:keys) {
      System.out.println(gn.toString());
      for(Edge e:g.get(gn)) {
        System.out.println(e.toString());
      }
      System.out.println();
    }
  }
}
class myComparator implements Comparator<GraphNode>
{
  @Override
  public int compare(GraphNode o1, GraphNode o2) {
    return Integer.compare(Integer.parseInt(o1.getName()),Integer.parseInt(o2.getName()));
  }
}