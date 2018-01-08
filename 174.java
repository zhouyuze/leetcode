public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int row = dungeon.length;
    int col = dungeon[0].length;
    int[] prev = new int[col];
    int[] cur = new int[col];

    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        cur[j] = Math.min(i != row - 1 ? prev[j] : Integer.MAX_VALUE,
            j != col - 1 ? cur[j + 1] : Integer.MAX_VALUE);
        if (cur[j] == Integer.MAX_VALUE) {
          cur[j] = 1;
        }
        cur[j] = Math.max(cur[j] - dungeon[i][j], 1);
      }
      int[] tmp = cur;
      cur = prev;
      prev = tmp;
    }

    return prev[0];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] map = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
    System.out.println(s.calculateMinimumHP(map));
  }
}