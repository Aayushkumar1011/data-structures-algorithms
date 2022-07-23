class Solution {
    public int longestStrChain(String[] words) {
        if(words.length == 1)
            return 1;
        int size = words.length;
        int res = 0;
        Arrays.sort(words, (str1, str2) -> str1.length() - str2.length());
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                if(isPredecessor(words[j], words[i]) && dp[i] < 1+dp[j]){
                    dp[i] = 1 + dp[j];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    boolean isPredecessor(String str1, String str2){
        int size1 = str1.length();
        int size2 = str2.length();
        int start1 = 0, start2 = 0;
        if(size2 - size1 != 1)
            return false;
        while(start2 < size2){
            if(start1 < size1 && str1.charAt(start1) == str2.charAt(start2)){
                start1++; start2++;
            }
            else{
                // bigger string
                start2++;
            }
        }
        return start1 == size1 && start2 == size2 ? true: false;
    }  
}
