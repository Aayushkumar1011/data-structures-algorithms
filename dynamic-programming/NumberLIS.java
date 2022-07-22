class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0, max = 1;
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];  
                    }
                else if(nums[j] < nums[i] && dp[i] == 1 + dp[j]){
                    count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        for(int i = 0; i < n; i++){
            if(max == dp[i]){
                res += count[i];
            }
        }
        return res;
    }
}
