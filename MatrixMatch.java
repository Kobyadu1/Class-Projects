package ProblemsInP;


public class MatrixMatch {
   public static void main(String[]args){
    int x = 30000;
    int y  = 30000;
    String[][] input = new String[x][y];
    String[][] input2 = new String[x][y];
    int count = 0;
    
    for(int i = 0;i<(Math.min(input.length, input2.length));i++) {
        for(int j = 0;j<(Math.min(input[0].length, input2[0].length));j++) { 
            count++;
            input[i][j] = "A";
            input2[i][j] = "A";
        }
     }

    Long startTime = System.nanoTime();
    System.out.println(matrixMatch(input,input2));
    Long endTime = System.nanoTime();
    
    System.out.println((endTime-startTime)/1000000.0);
   }
   public static boolean matrixMatch(String[][] one,String[][] two) {
    for(int i = 0;i<(Math.min(one.length, two.length));i++) {
        for(int j = 0;j<(Math.min(one[0].length, two[0].length));j++) {            
            if(!(one[i][j]).equals(two[i][j])) {
                return false;
            }
        }
    }
    return true;
  }
}
