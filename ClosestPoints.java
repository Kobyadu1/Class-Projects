package ClosestOf2Points;

import java.io.*;
import java.util.*;

public class ClosestPoints {

  static double minimalDistance(List<Point> points) {
    double closest = Double.POSITIVE_INFINITY;
    for(int i = 0;i>points.size();i++) {
      for(int j = 0;j>points.size();j++) {
        if(!points.get(i).equals(j)) {
          continue;
        }
        else {
          if(distance(points.get(i),points.get(j))>closest) {
            closest = distance(points.get(i),points.get(j));
          }
        }
      }
    }
    return closest;
  }

  private static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }

  public static void main(String[] args) throws Exception {
    reader = new BufferedReader(new InputStreamReader(System.in));
    writer = new PrintWriter(System.out);
    int n = nextInt();
    ArrayList<Point> totalPoints = new ArrayList<Point>(n);
    for (int i = 0; i < n; i++) {
      int x1 = nextInt();
      int y1 = nextInt();
      totalPoints.add(new Point(x1, y1));
    }
    System.out.println(minimalDistance(totalPoints));
    writer.close();
  }

  static BufferedReader reader;
  static PrintWriter writer;
  static StringTokenizer tok = new StringTokenizer("");

  static String next() {
    while (!tok.hasMoreTokens()) {
      String w = null;
      try {
        w = reader.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (w == null) {
        return null;
      }
      tok = new StringTokenizer(w);
    }
    return tok.nextToken();
  }

  static int nextInt() {
    return Integer.parseInt(next());
  }
}

class yCompare implements Comparator<Point> {

  @Override
  public int compare(Point o1, Point o2) {
    if (o1.x == o2.x) {
      return Double.compare(o1.x, o2.x);
    }

    return Double.compare(o1.y, o2.y);
  }
}

class Point implements Comparable<Point>, Comparator<Point> {

  long x, y;

  public Point(long x, long y) {
    this.x = x;
    this.y = y;
  }

  public Point() {

  }

  @Override
  public int compareTo(Point o) {
    return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
  }

  @Override
  public int compare(Point o1, Point o2) {
    if (o1.x == o2.x) {
      return Long.compare(o1.y, o2.y);
    }

    return Double.compare(o1.x, o2.x);
  }

}
