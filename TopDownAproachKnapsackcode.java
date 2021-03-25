import java.util.*;
public class TopDownAproachKnapsackcode {
  static  int knapsack(int[] wt, int[] val, int w,int n ){

        int[][] dp = new int[n+1][w+1];

        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<w+1;j++){
        //         if( (i==0) && (j==0))
        //             dp[i][j] = 0;
        //     }
        // }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max( (val[i-1]+dp[i-1][j-wt[i-1]]) ,(dp[i-1][j]) );
                    // System.out.println("i= "+i+"j= "+j + "  "+  dp[i][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][w];
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n=9;
        int[] wt = {96, 43, 28, 37, 92, 5, 3, 54, 93 };
        int[] val = {359, 963, 465, 706, 146, 282, 828, 962, 492};
        int w = 383;

        System.out.println( knapsack(wt,val,w,n));
    }
}
