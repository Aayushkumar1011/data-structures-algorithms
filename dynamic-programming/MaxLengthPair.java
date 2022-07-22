class Solution {
    public int findLongestChain(int[][] pairs) {
        int size = pairs.length;
        int[] dp = new int[size];
        int res = 1;
        
        Arrays.sort(pairs, (pair1, pair2)->pair1[0] - pair2[0]);
        Arrays.fill(dp, 1);
        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0] && dp[i] < 1+dp[j]){
                    dp[i] = 1 + dp[j];
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
