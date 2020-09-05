package TSP;

import java.util.ArrayList;

//graph node class, has size/weight, list of connected nodes(out/in), name
public class GraphNode{
  private double size;
  private ArrayList<GraphNode>connectingNodes;
  
  private String name;
  
  public GraphNode(double size,ArrayList<GraphNode>connectingNodes,String name){
	this.size = size;
	this.connectingNodes = connectingNodes;
	this.name = name;
  }
  public GraphNode(double size,String name){
	this.size = size;
	connectingNodes = new ArrayList<GraphNode>();
	this.name = name;
  }
  public GraphNode(){
	size = 0;
	connectingNodes = new ArrayList<GraphNode>();
	name = "";
  }
  public void addConnectingNode(GraphNode nodeToAdd) {
	connectingNodes.add(nodeToAdd);
  }
  public void removeConnectingNode(GraphNode nodeToRemove) {
	connectingNodes.remove(nodeToRemove);
  }
  public double getSize() {
	return size;
  }
  public void setSize(double size) {
	this.size = size;
  }
  public ArrayList<GraphNode> getConnectingNodes() {
	return connectingNodes;
  }

  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
//  public String toString() {
//	return "This graphnode is named "+name+", has a size of "+size+" and has "+connectingNodes.size()+" node(s)."+
//		" These node(s) are "+showNames().toString();
//  }
  public String toString() {
	return name;
  }
  public ArrayList<String> showNames() {
	ArrayList<String> connectingNames = new ArrayList<String>(connectingNodes.size());
	for(GraphNode gn:connectingNodes) {
	  connectingNames.add(gn.getName());
	}
	return connectingNames;
  }
}
