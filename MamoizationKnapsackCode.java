import java.util.*;
import java.math.*;
public class MamoizationKnapsackCode {

    static int knapsack(int[] val , int[] wt, int w, int n , int[][] dp){

        if(w==0 || n==0 )
            return 0;
        if(dp[w][n]!=-1)
            return dp[w][n];
        if(wt[n-1] <= w)
            return dp[w][n] = Math.max( (val[n-1]+knapsack(val, wt, w-wt[n-1], n-1, dp)), (knapsack(val, wt, w, n-1, dp)));
        else 
            return dp[w][n] = knapsack(val, wt, w, n-1, dp);
    }
    public static void main(String[] args ){

        int[][] dp = new int[10000][10000];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of array = ");
        int n = scan.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];
        System.out.println("Enter the element for weight array ");

        for(int i=0;i<n;i++)
            wt[i] = scan.nextInt();
        
        System.out.println("Enter the element for value array ");

        for(int i=0;i<n;i++)
            val[i] = scan.nextInt();

        System.out.print("Enter the weight of knapsack = ");

        int w = scan.nextInt();

        System.out.println(knapsack(val, wt, w, n, dp));


    }
}
