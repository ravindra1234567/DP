import java.util.*;
 class RodCutting  {
    static int rodCutting(int[] length,int[] price, int n){
        int arrLength = length.length;
        int[][] dp = new int[arrLength+1][n+1];

        for(int i=1;i<arrLength+1;i++){
            for(int j=1;j<n+1;j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max( (price[i-1]+dp[i][j-length[i-1]]), dp[i-1][j] );
                }else   
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[arrLength][n];
    }
    public static void main(String[] args){
        int[] lenght = {1,2,3,4,5,6,7,8 };
        int[] price = {3,5,8,9,10,17,17,20};
        int n = 8;
        System.out.println(rodCutting(lenght,price,n));
    }
}
