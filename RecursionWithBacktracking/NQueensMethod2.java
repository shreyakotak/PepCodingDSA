import java.util.Scanner;

public class NQueensMethod2 {
    private static int rdir[] = {-1, -1, -1};
    private static int cdir[] = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] chess = new int[n][n];
        printNQueens(chess, 0, 0, 0, "");
    }

    //qpsf = queens placed so far
    //asf = answer so far
    //This is the 'subsequence' approach. It means 'yes' or 'no' approach. Each cell have 2 choices, 'yes' or 'no'. Here traversal is cell wise.
    //Time complexity for this logic is n*(2^n)
    public static void printNQueens(int[][] chess, int row, int col, int qpsf, String asf) {  
        int n = chess.length;
        if(row == n){
            if(qpsf == n)
                System.out.println(asf+".");
            return;
        }

        if(col+1 < n){
            //Yes call
            if(isSafePosition(chess, row, col)){
                chess[row][col] = 1;
                printNQueens(chess, row + 1, 0, qpsf+1, asf + row + "-" + col + ", ");
                chess[row][col] = 0;
            }

            //No call
            printNQueens(chess, row, col + 1, qpsf, asf);
        }else{
            //Yes call
            if(isSafePosition(chess, row, col)){
                chess[row][col] = 1;
                printNQueens(chess, row + 1, 0, qpsf+1, asf + row + "-" + col + ", ");
                chess[row][col] = 0;
            }

            //No call
            printNQueens(chess, row + 1, 0, qpsf, asf);
        }
    }

    private static boolean isSafePosition(int[][] chess, int row, int col){
        int n = chess.length;

        for(int dir = 0; dir < rdir.length; dir++){
            for(int radious = 1; radious<=n; radious++){
                int rr = row + (radious * rdir[dir]);
                int cc = col + (radious * cdir[dir]);

                if(rr < n && rr >= 0 && cc < n && cc >= 0){
                    if(chess[rr][cc] == 1)
                        return false;
                }else{
                    break;
                }
            }
        }

        return true;
    }
}
