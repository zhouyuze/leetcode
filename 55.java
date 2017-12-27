public class Solution {
  public boolean canJump(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    set.add(0);
    int min = 0;

    for (int i = nums.length - 1; i >= 0; i--) {
      int cur = nums[i];
      if (cur >= min) {
        if (i == 0) {
          return true;
        }
        min = 1;
        continue;
      }
      min += 1;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {2, 3, 1, 1, 4};
    System.out.println(s.canJump(nums));
  }
}