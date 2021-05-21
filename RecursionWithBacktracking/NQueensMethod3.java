import java.util.Scanner;

public class NQueensMethod3 {
    private static int rdir[] = {-1, -1, -1};
    private static int cdir[] = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] chess = new int[n][n];
        printNQueens(chess, 0, "");
    }

    //asf = answer so far
    //This is 'Options' approach. It means in a matrix of 4, for each row there are 4 options(columns) where queen can be placed. Here traversal is per row wise and for each row it will traverse all the column
    public static void printNQueens(int[][] chess, int row, String asf) {  
        int n = chess.length;
        if(row == n){
            System.out.println(asf+".");
            return;
        }

        for(int col=0; col<n; col++){
            if(isSafePosition(chess, row, col)){
                chess[row][col] = 1;
                printNQueens(chess, row + 1, asf + row + "-" + col + ", ");
                chess[row][col] = 0;
            }
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