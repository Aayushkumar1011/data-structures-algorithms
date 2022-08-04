//1143. Longest Common Subsequence
//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the 
//relative order of the remaining characters.
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.
//https://leetcode.com/problems/longest-common-subsequence/
//Time Complexity: O(n^2)
//Auxiliary Space: O(n^2)



class Solution {
public:
    int longestCommonSubsequence(string x, string y) {
        int m=x.length();
        int n=y.length();
        int dp[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(x[i-1]==y[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
};
