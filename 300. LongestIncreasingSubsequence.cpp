//300. Longest Increasing Subsequence
//Given an integer array nums, return the length of the longest strictly increasing subsequence.
//A subsequence is a sequence that can be derived from an array by deleting some or no elements
//without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//https://leetcode.com/problems/longest-increasing-subsequence/


//Time Complexity: O(n2). 
//Auxiliary Space: O(n). 
  


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        int lis[n+1];
        lis[0]=1;
        for(int i=1;i<n;i++)
        {
            lis[i]=1;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                    lis[i]=max(lis[i],lis[j]+1);
            }
        }
            int res=lis[0];
            for(int i=1;i<n;i++)
                res=max(res,lis[i]);
            return res;
        }
    
};
