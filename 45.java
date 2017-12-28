public class Solution {
  public int jump(int[] nums) {
    int[] minStep = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i == nums.length - 1) {
        minStep[i] = 0;
      } else if (nums[i] < 1) {
        minStep[i] = Integer.MAX_VALUE;
      } else {
        int farest = minStep[Math.min(i + nums[i], nums.length - 1)];
        if (farest == Integer.MAX_VALUE) {
          minStep[i] = farest;
        } else {
          minStep[i] = farest + 1;
          int j = i + 1;
          for (; minStep[j] > minStep[i] && j < nums.length; j++) {
            minStep[j] = minStep[i];
          }
        }
      }
    }
    return minStep[0];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] height = {2, 0, 2, 4, 6, 0, 0, 3};
    System.out.println(s.jump(height));
  }
}