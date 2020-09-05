package TSP;



//ege node class, has length, name, start and end 
public class Edge {
  private double length;
  private String name;
  private GraphNode start;
  private GraphNode end;
  
  public Edge(GraphNode start,GraphNode end,double length,String name){
	this.length = length;
	this.start = start;
	this.end = end;
	this.name = name;
  }
  public Edge(){
	length = 0;
	start = null;
	end = null;
	name = "";
  }
  public Edge(GraphNode start,GraphNode end) {
   length = 0;
   this.start = start;
   this.end = end;
   name = "";
 }
  public double getLength() {
	return length;
  }
public void setLength(double length) {
  this.length = length;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public GraphNode getStart() {
  return start;
}
public void setStart(GraphNode start) {
  this.start = start;
}
public GraphNode getEnd() {
  return end;
}
public void setEnd(GraphNode end) {
  this.end = end;
}
  public String toString() {
    return "This edge starts at node "+start.getName()+" and ends at node "+end.getName()+" and spans a length of "+length;
}
  
}
