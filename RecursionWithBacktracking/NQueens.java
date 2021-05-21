import java.util.*;

/*
Question:
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format:
A number n

Constraints:
1 <= n <= 10

Sample Input:
4

Sample Output:
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

Note: We must have n > 3 then only We can place n queens on n*n board in such a way that no queen can kill other queens
*/

public class NQueens {

    //For Approach 2
    /*private static int rdir[] = {-1, -1, -1, 1, 1, 1};
    private static int cdir[] = {-1, 0, 1, 1, 0, -1};*/

    //You can check only upside rows vertically and diagonally, whether queen is placed or not
    //No need to check downside rows
    private static int rdir[] = {-1, -1, -1};
    private static int cdir[] = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0, 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row, int col) {  
        int n = chess.length;
        if(row == n){
            System.out.println(qsf+".");
            return;
        }

        //Yes Call
        if(isSafePosition(chess, row, col)){
            chess[row][col] = 1;
            printNQueens(chess, qsf + row + "-" + col + ", ", row + 1, 0);
            chess[row][col] = 0;
        }

        //No call
        if(col + 1 < n)
            printNQueens(chess, qsf, row, col + 1);
    }

    private static boolean isSafePosition(int[][] chess, int row, int col){
        int n = chess.length;

        /*//Approach 1: This approach will check all the 6 directions, but no need to check all the six directions, just check upward 3 directions for diagonally and vertically placed queens
        //To check vertically
        for(int r=0; r < n; r++){
            if(chess[r][col] == 1)
                return false;
        }

        //To check diagonally upward left
        for(int r=row-1, c=col-1; r>=0 && c>=0; r--, c--){
            if(chess[r][c] == 1)
                return false;
        }

        //To check diagonally downward left
        for(int r=row+1, c=col-1; r<n && c>=0; r++, c--){
            if(chess[r][c] == 1)
                return false;
        }

        //To check diagonally upward right
        for(int r=row-1, c=col+1; r>=0 && c<n; r--, c++){
            if(chess[r][c] == 1)
                return false;
        }

        //To check diagonally downward right
        for(int r=row+1, c=col+1; r<n && c<n; r++, c++){
            if(chess[r][c] == 1)
                return false;
        }

        return true;*/

        /*//Approach 2: This approach will check all the 6 directions, but no need to check all the six directions, just check upward 3 directions for diagonally and vertically placed queens
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

        return true;*/

        /*//Approach 3: This approach will check only upward 3 directions
        //To check vertically upward
        for(int r=0; r < row; r++){
            if(chess[r][col] == 1)
                return false;
        }

        //To check diagonally upward left
        for(int r=row-1, c=col-1; r>=0 && c>=0; r--, c--){
            if(chess[r][c] == 1)
                return false;
        }

        //To check diagonally upward right
        for(int r=row-1, c=col+1; r>=0 && c<n; r--, c++){
            if(chess[r][c] == 1)
                return false;
        }

        return true;*/

        //Approach 4: This approach will check only upward 3 directions
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