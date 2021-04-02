import java.util.*;
public class CoinChangeMaximunNumberOfWay {

    static int countMaxWay(int[] coins,int sum){
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0)
                    dp[i][j] = 1;
                if(i==0)
                    dp[i][j] = 0;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1] <= j)
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]; 
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args){
        int coins[] = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 };
        int sum = 458;

        System.out.println(countMaxWay(coins,sum));


    }
}
