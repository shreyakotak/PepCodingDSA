public class PrintWaysIn2D1 {

    //Ques: Print selection of boxes where selection from same row does not come

    public static void main(String[] args) {
        printWays(2, 2, 0, 0, 0, "");
    }

    //n = total row, m = total col
    //direction of matrix = m*n, r = row, c = col, bsf = box so far, asf = answer so far
    public static void printWays(int n, int m, int r, int c, int bsf, String asf){
        //Approach 2
        if(r == n){
            System.out.println(asf);
            return;
        }

        if(c + 1 < m){ //when next column is valid
            //Yes call
            printWays(m, n, r + 1, 0, bsf + 1, asf + "(" + r + "," + c +")");
            //No call
            printWays(m, n, r, c + 1, bsf, asf);
        }else{ //when next column is invalid
            //Yes call
            printWays(m, n, r + 1, 0, bsf + 1, asf + "(" + r + "," + c +")");
            //No call
            printWays(m, n, r + 1, 0, bsf, asf);
        }
    }
}