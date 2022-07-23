class Solution {
    final int SIZE = (int)1e4+1;
    public int deleteAndEarn(int[] nums) {
        int include = 0;
        int exclude = 0;
        int[] count = new int[SIZE];
        for(int num: nums)
            count[num]++;
        
        for(int i = 0; i < SIZE; i++){
            int newInclude = exclude + count[i]*i;
            int newExclude = Math.max(include, exclude);
            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include, exclude);
    }
}
