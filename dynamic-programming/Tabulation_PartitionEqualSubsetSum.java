class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
        if(sum%2 != 0)
            return false;
        return subsetSum(nums, nums.length, sum/2);
    }
    
    private boolean subsetSum(int[] arr, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i < n+1; i++)
            dp[i][0] = true;
        for(int j = 1; j < sum+1; j++)
            dp[0][j] = false;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
