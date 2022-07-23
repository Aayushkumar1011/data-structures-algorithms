class Solution {
    public int rob(int[] nums) {
        int evenHouse = 0;
        int oddHouse = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0)
                evenHouse = Math.max(evenHouse + nums[i], oddHouse);
            else
                oddHouse = Math.max(evenHouse, oddHouse + nums[i]);
        }
        return Math.max(evenHouse, oddHouse);
    }
}
