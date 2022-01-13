class Solution {
   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       
         if (nums == null || nums.length == 0) return false;
    TreeSet<Long> set = new TreeSet<>();
    set.add((long) nums[0]);
    for (int i = 1; i < nums.length; i++) {
        if (i > k) set.remove((long) nums[i - k - 1]);
        long left = (long) nums[i] - t;
        long right = (long) nums[i] + t;
        if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;
        set.add((long) nums[i]);
    }
    return false;
           

   }
}