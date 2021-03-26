import java.util.*;
public class EqualSumPartition{

    static boolean subSetSum(int[] arr,int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            } 
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = (dp[i-1][j-arr[i-1]]) || (dp[i-1][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    static boolean equalSumPartition(int[] arr,int n){
        int sum2 = Arrays.stream(arr).sum();
        if( (sum2&1) == 0){
            return subSetSum(arr, sum2/2);
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,5,11,5,2,1,4};
        int n = 5;
        System.out.println(equalSumPartition(arr,n));
    }
}