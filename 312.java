public class Solution {
  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int[][] max = new int[nums.length][nums.length];

    for (int len = 1; len <= nums.length; len++) {
      for (int start = 0; start <= nums.length - len; start++) {
        int end = start + len - 1;
        max[start][end] = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
          int coin = nums[i] * getNum(start - 1, nums) * getNum(end + 1, nums);
          coin += i != start ? max[start][i - 1] : 0;
          coin += i != end ? max[i + 1][end] : 0;
          max[start][end] = Math.max(max[start][end], coin);
        }
      }
    }
    return max[0][nums.length - 1];
  }

  public int getNum(int pos, int[] nums) {
    if (pos > nums.length - 1 || pos < 0) {
      return 1;
    } else {
      return nums[pos];
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {3, 1, 5, 8};
    System.out.println(s.maxCoins(nums));
  }
}