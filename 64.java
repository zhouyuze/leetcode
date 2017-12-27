public class Solution {
  public int minPathSum(int[][] grid) {
    int[] prev = new int[grid[0].length];
    int[] cur = new int[grid[0].length];
    prev[0] = grid[0][0];

    for (int i = 1; i < prev.length; i++) {
      prev[i] = prev[i - 1] + grid[0][i];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 0; j < prev.length; j++) {
        if (j == 0) {
          cur[j] = prev[j] + grid[i][j];
        } else {
          cur[j] = Math.min(prev[j] + grid[i][j], cur[j - 1] + grid[i][j]);
        }
      }
      int[] tmp = prev;
      prev = cur;
      cur = tmp;
    }

    return prev[prev.length - 1];
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(s.minPathSum(nums));
  }
}