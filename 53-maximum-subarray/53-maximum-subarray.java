class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE, currsum=0;
        
        for(int i=0;i<nums.length;i++) {
            currsum=nums[i]+currsum;
            currsum=Math.max(currsum, nums[i]);
            
            sum=Math.max(sum, currsum);
        }
        return sum;
    }
}