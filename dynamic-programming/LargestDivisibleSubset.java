class LargestDivisibleSubset {    
  public List<Integer> largestDivisibleSubset(int[] arr) {
        if(arr.length == 0)
            return new ArrayList<>();
        int size = arr.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        Arrays.sort(arr);
        int maxLIS = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < size; i++){
//             maxLIS = 1;
            for(int j = 0; j < i; j++){
                if(arr[i]%arr[j] == 0 && dp[i] < 1+dp[j]){
                    dp[i] = 1 + dp[j];
                    maxLIS = Math.max(maxLIS, dp[i]); 
                }
            }
        }
        
        int prev = -1;
        for(int i = size-1; i >= 0; i--){
            if((dp[i] == maxLIS) && (prev%arr[i]%2 == 0 || prev == -1)){
                maxLIS--;
                res.add(arr[i]);
                prev = arr[i];
            }
        }
        
        return res;
    }
}
