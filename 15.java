public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 1; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int left = j + 1, right = nums.length - 1;
        while (left <= right) {
          int middle = (left + right) / 2;
          if (nums[i] + nums[j] + nums[middle] < 0) {
            left = middle + 1;
          } else if (nums[i] + nums[j] + nums[middle] > 0) {
            right = middle - 1;
          } else {
            List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[middle]);
            result.add(ans);
            break;
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(s.threeSum(nums));
  }
}