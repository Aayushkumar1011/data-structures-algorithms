public class Solution {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++)
            dp[i][0] = 0;
        for(int j = 0; j < m+1; j++)
            dp[0][j] = 0;
            
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
