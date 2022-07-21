//673. Number of Longest Increasing Subsequence
//Given an integer array nums, return the number of longest increasing subsequences.
//Notice that the sequence has to be strictly increasing.
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/




class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n = nums.size();
        int maxlength = 1, num = 0;
        vector<int> count(n, 1), length(n, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                
                if (nums[i] > nums[j]) {
                    
                    if (length[j]+1 > length[i]) {
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }
                    else if (length[j]+1 == length[i]) 
                        count[i] += count[j];
                }
            }
            maxlength = max(maxlength, length[i]);
        }
        
        
        for (int i = 0; i < n; i++) {
            if (length[i] == maxlength) 
                num += count[i];
        }
        
        return num;
    
    }
};
