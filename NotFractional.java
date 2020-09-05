package Knapsack;

import java.util.ArrayList;

public class NotFractional {

  public static int compute(ArrayList<Integer>objects, int weight) {
    int greatestAmount = 0;
    int value = 0;
    ArrayList<ArrayList<Integer>> possible = new ArrayList<>();
    for(int j = 1;j<=objects.size();j++) {
      possible.addAll(getPermutations(objects,j,0));
    }
    for(ArrayList<Integer> intArray:possible) {
      if(total(intArray)>weight&&intArray.size()>greatestAmount) {
        greatestAmount = intArray.size();
        value = total(intArray);
      }
    }
    return value;
  }
  
  public static ArrayList<ArrayList<Integer>> getPermutations (ArrayList<Integer> elements, int k, int i) {
    ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    if(k > 0) {
        int n = elements.size();
        for(int j = i; j <= n-k; j++) {
            int val = elements.get(j);
            ArrayList<ArrayList<Integer>> tails = getPermutations(elements,k-1,j+1);
            for(ArrayList<Integer> tail : tails) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(val);
                result.addAll(tail);
                results.add(result);
            }
        }
    } 
    else {
        results.add(new ArrayList<Integer>());
    }
    return results;
}
  
  public static int total(ArrayList<Integer>list) {
    int total = 0;
    for(int i:list) {
      total+=i;
    }
    return total;
  }
          
  public static void main(String[]args) {
    ArrayList<Integer> items = new ArrayList<Integer>();
    for(int i = 1;i<=30;i++) {
      items.add(i);
    }

    System.out.println(compute(items,4));
  }
}
