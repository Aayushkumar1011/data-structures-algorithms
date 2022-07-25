public class Solution {
    public int solve(ArrayList<Integer> arr, int sum) {
        int size = arr.size();
        boolean[][] dp = new boolean[size+1][sum+1];
        
        for(int i = 0; i <= size; i++)
            dp[i][0] = true;
        for(int j = 1; j <= sum; j++)
            dp[0][j] = false;
            
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= sum; j++){ 
                if(arr.get(i - 1) <= j)
                    dp[i][j] = dp[i - 1][j - arr.get(i - 1)] 
                                    || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }       
        return dp[size][sum] == true ? 1 : 0;
    }
}
