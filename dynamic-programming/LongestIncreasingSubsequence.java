//300. Longest Increasing Subsequence
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int size = nums.length;
        int[] dp = new int[size];
        int res = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < size; i++){
            int curLIS = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    curLIS = Math.max(curLIS, dp[j]);
                }
            }
            dp[i] = 1 + curLIS;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
