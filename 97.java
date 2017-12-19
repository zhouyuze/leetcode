class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length(), n = s2.length();
    if (m + n != s3.length()) {
      return false;
    }
    int[][] invalid = new int[m + 1][n + 1];
    return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, invalid);
  }

  public boolean dfs(char[] s1, char[] s2, char[] s3, int i, int j, int k, int[][] invalid) {
    if (k == s3.length) {
      return true;
    }

    if (invalid[i][j] != 0) {
      return false;
    }

    if (i < s1.length && s1[i] == s3[k]) {
      if (dfs(s1, s2, s3, i + 1, j, k + 1, invalid)) {
        return true;
      }
    }

    if (j < s2.length && s2[j] == s3[k]) {
      if (dfs(s1, s2, s3, i, j + 1, k + 1, invalid)) {
        return true;
      }
    }
    invalid[i][j] = 1;
    return false;
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
}