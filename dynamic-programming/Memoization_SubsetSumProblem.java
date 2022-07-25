public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        int[][] dp = new int[size+1][B+1];
        for(int i = 1; i < size+1; i++)
            Arrays.fill(dp[i], -1);
        return isSubsetExist(A, dp, B, size);
    }
    
    public int isSubsetExist(ArrayList<Integer> arr, int[][] dp, int sum, int size){
        if(sum == 0)
            return dp[size][sum] = 1;
        if(size == 0)
            return dp[size][sum] = 0;
        if(dp[size][sum] != -1)
            return dp[size][sum];
        if(arr.get(size - 1) <= sum)
            return dp[size][sum] = Math.max(
                isSubsetExist(arr, dp, sum - arr.get(size - 1), size - 1),
                isSubsetExist(arr, dp, sum, size - 1)
                );
        else
            return dp[size][sum] = isSubsetExist(arr, dp, sum, size - 1);
        
    }
}
