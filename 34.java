public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] ans = new int[2];
    if (nums.length == 0) {
      ans[0] = -1;
      ans[1] = -1;
      return ans;
    }

    int left = search(nums, target - 0.5);
    int right = search(nums, target + 0.5);

    if (nums[left] != target) {
      left++;
    }
    if (nums[right] != target) {
      right--;
    }

    if (left <= right) {
      ans[0] = left;
      ans[1] = right;
    } else {
      ans[0] = -1;
      ans[1] = -1;
    }

    return ans;
  }

  private int search(int[] nums, double target) {
    int left = 0, right = nums.length - 1;
    int middle = 0;
    while (left <= right) {
      middle = (left + right) / 2;
      if (nums[middle] < target) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return middle;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {5, 7, 7, 8, 8, 10};
    for (int i : s.searchRange(nums, 8)) {
      System.out.println(i);
    }
  }
}