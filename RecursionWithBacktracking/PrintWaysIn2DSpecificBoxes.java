public class PrintWaysIn2DSpecificBoxes {
    public static void main(String[] args) {
        printWays(2, 2, 0, 0, 0, "");
    }

    //n = total row, m = total col
    //direction of matrix = m*n, r = row, c = col, bsf = box so far, asf = answer so far
    public static void printWays(int n, int m, int r, int c, int bsf, String asf){
        if(r == n){
            if(bsf == 2)
                System.out.println(asf);
            return;
        }

        if(c + 1 < m){ //when next column is valid
            //Yes call
            printWays(m, n, r, c + 1, bsf + 1, asf + "(" + r + "," + c +")");
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
