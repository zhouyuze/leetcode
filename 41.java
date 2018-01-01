public class Solution {
  public int firstMissingPositive(int[] nums) {
    int ans = nums.length + 1;
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length) {
        if (nums[nums[i] - 1] == nums[i]) {
          break;
        }
        int tmp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = tmp;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        ans = i + 1;
        break;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {3, 4, -1, 1};
    System.out.println(s.firstMissingPositive(nums));
  }
}