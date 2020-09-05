package ProblemsInP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class StringExchange {

  public static void main(String[] args) {

    key k = new key(new HashMap<>());
    k.addtoKey('a', '<');
    k.addtoKey('A', '<');
    k.addtoKey('b', ')');
    k.addtoKey('B', ')');
    k.addtoKey('c', '#');
    k.addtoKey('C', '#');
    k.addtoKey('d', '%');
    k.addtoKey('D', '%');
    k.addtoKey('e', '^');
    k.addtoKey('E', '^');
    k.addtoKey('f', '*');
    k.addtoKey('F', '*');
    k.addtoKey('g', '(');
    k.addtoKey('G', '(');
    k.addtoKey('h', '~');
    k.addtoKey('H', '~');
    k.addtoKey('i', '`');
    k.addtoKey('I', '`');
    k.addtoKey('j', '�');
    k.addtoKey('J', '�');
    k.addtoKey('k', '+');
    k.addtoKey('K', '+');
    k.addtoKey('l', '=');
    k.addtoKey('L', '=');
    k.addtoKey('m', '-');
    k.addtoKey('M', '-');
    k.addtoKey('n', '_');
    k.addtoKey('N', '_');
    k.addtoKey('o', '/');
    k.addtoKey('O', '/');
    k.addtoKey('p', '?');
    k.addtoKey('P', '?');
    k.addtoKey('q', '!');
    k.addtoKey('Q', '!');
    k.addtoKey('r', 'X');
    k.addtoKey('R', 'X');
    k.addtoKey('s', '[');
    k.addtoKey('S', '[');
    k.addtoKey('t', '{');
    k.addtoKey('T', '{');
    k.addtoKey('u', '}');
    k.addtoKey('U', '}');
    k.addtoKey('v', '\\');
    k.addtoKey('V', '\\');
    k.addtoKey('w', '|');
    k.addtoKey('W', '|');
    k.addtoKey('x', ']');
    k.addtoKey('X', ']');
    k.addtoKey('y', '$');
    k.addtoKey('Y', '$');
    k.addtoKey('z', 'E');
    k.addtoKey('Z', 'E');
    
    Random rand = new Random();
    
    Scanner multi = new Scanner(System.in);
    //String input = multi.nextLine();
    
    String input="";
    Object[] keys = k.keyList.keySet().toArray();
    int x = 30000;
    for(int i = 0;i<x;i++) {
        input = input+""+keys[10];
    }
    
    
    System.out.println(input.length());
    Long startTime = System.nanoTime();
    k.convert(input);
    Long endTime = System.nanoTime();
    System.out.println((endTime-startTime)/1000000.0);
    
    System.out.println(k.convert(input));
  }

  private static String convert(String toConvert) {
    return toConvert;
  }

  private static String toString(ArrayList<Character> convert) {
    String ret = "";
    for (char c : convert) {
      ret += c;
    }
    return ret;
  }

}

class key {

  HashMap<Character, Character> keyList;

  public key(HashMap<Character, Character> keyList) {
    this.keyList = keyList;
  }

  public void addtoKey(char normal, char code) {
    this.keyList.put(normal, code);
  }

  public ArrayList<Character> convert(String toConvert) {
    char[] word = toConvert.toCharArray();
    ArrayList<Character> ret = new ArrayList<Character>();
    for (int i = 0; i < toConvert.length(); i++) {
      if (this.keyList.containsKey(word[i])) {
        ret.add(this.keyList.get(word[i]));
      } else {
        ret.add(' ');
      }
    }
    return ret;
  }

}
