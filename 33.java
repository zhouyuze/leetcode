public class Solution {
  public int search(int[] nums, int target) {
    int pos = -1;
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        pos = middle;
        break;
      }
      if (nums[left] <= nums[right]) {
        if (nums[middle] < target) {
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      } else {
        if (nums[middle] >= nums[left]) {
          if (target <= nums[middle] && target >= nums[left]) {
            right = middle - 1;
          } else {
            left = middle + 1;
          }
        } else {
          if (target >= nums[middle] && target <= nums[right]) {
            left = middle + 1;
          } else {
            right = middle - 1;
          }
        }
      }
    }
    return pos;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {3,5,1};
    System.out.println(s.search(nums, 3));
  }
}