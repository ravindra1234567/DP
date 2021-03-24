import java.util.*;
public class RecurciveKnapsackCode{

    static int knapsack(int[] arr,int[] wt, int w, int n){
        if(w==0 || n==0)
            return 0;

        if(wt[n-1] <= w)
            return Math.max(arr[n-1]+knapsack(arr, wt, w-wt[n-1], n-1),knapsack(arr, wt, w, n-1));
        else 
            return knapsack(arr, wt, w, n-1);

    }
    public static void main(String[] args ){

        int[] arr = {60,100,120};
        int wt[] = {10,20,30};
        int w = 50;
       System.out.println(knapsack(arr,wt,w,3));

    }
}