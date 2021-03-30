import java.util.*;

public class MinimunSubsetSumDifferent {

    static int subsetSum(int[] arr, int sum) {
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        for (int j = 0; j < (sum + 1) / 2; j++) {
            if (dp[n][j]) {
                al.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<al.size();i++){
            min = Math.min(min,(sum-2*(al.get(i))));
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 6,11,5 };

        int sum = Arrays.stream(arr).sum();
      
      System.out.println(subsetSum(arr, sum));

    }

}
