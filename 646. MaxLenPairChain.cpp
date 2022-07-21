//646. Maximum Length of Pair Chain
//You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
//A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
//Return the length longest chain which can be formed.
//You do not need to use up all the given intervals. You can select pairs in any order.
//https://leetcode.com/problems/maximum-length-of-pair-chain/



class Solution
{
public:
    int findLongestChain(vector<vector<int>> &pairs)
    {
        int n = pairs.size();
        sort(pairs.begin(), pairs.end(), [](auto a, auto b)
             { return a[0] < b[0]; });
        vector<int> chain(n, 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (pairs[j][1] < pairs[i][0])
                    chain[i] = max(chain[i], chain[j] + 1);
            }
        }
        return *max_element(chain.begin(), chain.end());
    }
};
