import java.util.*;

public class MinimumNumberOfCoins {
    // static int minmumNumberOfCoins(int[] coins, int sum) {
    //     int n = coins.length;

    //     int[] dp = new int[sum + 1];

    //         dp[0] = 0;

    //         for(int i=1;i<sum+1;i++){
    //             dp[i] = Integer.MAX_VALUE;
    //         }
    //     for (int i = 1; i < sum + 1; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (coins[j] <= i){
    //                 int sub_result = dp[i-coins[j]];

    //                 if(sub_result!=Integer.MAX_VALUE && sub_result+1 < dp[i])
    //                     dp[i] = sub_result+1;
    //             }
    //         }
    //     }

    //     return dp[sum] == Integer.MAX_VALUE ? 1 : dp[sum] ;
    // }

    static int minmumNumberOfCoins(int coins[],int v) 
	{ 
        int n=coins.length;
	    int[][] dp = new int[n+1][v+1];
	    
	    // Arrays.sort(coins);
	    
	    for(int i=1;i<v+1;i++){
	        dp[0][i] = Integer.MAX_VALUE-1;
	       
	    }
	    
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<v+1;j++){
	            if(coins[i-1] <= j)
	                dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j]);
	             else
	                dp[i][j] = dp[i-1][j];
	        }
	    }
	    
	    System.out.println(dp[n][v]+" "+Integer.MAX_VALUE);
	    
	    return dp[n][v] >= Integer.MAX_VALUE-1 ? -1 : dp[n][v];   
	}
    public static void main(String[] args) {
        int[] coins = {11, 13, 5, 18, 16 ,22, 15, 8 ,21};
        Arrays.sort(coins);
        int sum = 14;

        System.out.println(minmumNumberOfCoins(coins, sum));
    }
}
