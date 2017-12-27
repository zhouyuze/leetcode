public class Solution {
  public void rotate(int[][] matrix) {
    int len = matrix.length;
    for (int i = 0; i < len / 2; i++) {
      for (int j = i; j < len - 1 - i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[len - 1 - j][i];
        matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
        matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
        matrix[j][len - 1 - i] = tmp;
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] nums = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 6}};
    s.rotate(nums);
  }
}