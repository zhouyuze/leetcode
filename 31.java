public class Solution {
  public void nextPermutation(int[] nums) {
    int pos = -1;

    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        pos = i;
        break;
      }
    }
    if (pos != -1) {
      for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] > nums[pos]) {
          int tmp = nums[i];
          nums[i] = nums[pos];
          nums[pos] = tmp;
          break;
        }
      }
    }

    int left = pos + 1, right = nums.length - 1;
    for (int i = left; i <= (left + right) / 2; i++) {
      int tmp = nums[i];
      nums[i] = nums[left + right - i];
      nums[left + right - i] = tmp;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {3, 2, 5, 4, 1};
    s.nextPermutation(nums);
    for (int n : nums) {
      System.out.println(n + " ");
    }
  }
}