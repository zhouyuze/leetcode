public class Solution {
  public int maxProfit(int[] prices) {
    int ans = 0;
    int[] left = new int[prices.length];
    int[] right = new int[prices.length];

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }
      if (i == 0) {
        left[i] = 0;
      } else {
        left[i] = Math.max(left[i - 1], prices[i] - min);
      }
    }

    for (int i = prices.length - 1; i >= 0; i--) {
      if (prices[i] > max) {
        max = prices[i];
      }
      if (i == prices.length - 1) {
        right[i] = 0;
      } else {
        right[i] = Math.max(right[i + 1], max - prices[i]);
      }
    }

    for (int i = 0; i < prices.length - 1; i++) {
      ans = Math.max(ans, left[i] + right[i]);
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {3, 3, 5, 0, 0, 3, 1, 4};
    System.out.println(s.maxProfit(nums));
  }
}