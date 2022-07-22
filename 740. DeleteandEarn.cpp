//740. Delete and Earn
//You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

//Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
//Return the maximum number of points you can earn by applying the above operation some number of times.



class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n=nums.size();                
        if(n==1) return nums[0];          
        int points[10001] = {0};           
		int del=0;               
        int delPrev=0;           
        int m=0;                
        
        for(int num: nums){         
            points[num] += num;     
            if(num>m) m=num;        
        }
        
        for(int i=0;i<10001;i++){
            if(i>m) break;                     
            int delTemp = delPrev + points[i];        
            int delPrevTemp = max(del,delPrev);      
            
            del = delTemp;
            delPrev = delPrevTemp;
        }
        return max(del,delPrev);  
        
    }
};
