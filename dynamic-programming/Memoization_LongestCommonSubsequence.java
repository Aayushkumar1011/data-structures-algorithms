public class Solution {
    
    public int solve(String A, String B) {
        int[][] dp = new int[A.length()+1][B.length()+1];
        for(int i = 0; i < A.length()+1; i++)
            Arrays.fill(dp[i], -1);
        return getLCS(A, B, A.length(), B.length(), dp);
    }
    
    private int getLCS(String A, String B, int n, int m, int[][] dp){
        if(n == 0 || m == 0)
            return dp[n][m] = 0;
        if(dp[n][m] != -1)
            return dp[n][m];
        if(A.charAt(n-1) == B.charAt(m-1))
            return dp[n][m] = 1 + getLCS(A, B, n-1, m-1, dp);
        else
            return dp[n][m] = Math.max(getLCS(A, B, n-1, m, dp), 
                                        getLCS(A, B, n, m-1, dp));
    }
}
