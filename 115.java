class Solution {
  public int numDistinct(String s, String t) {
    int[][] count = new int[t.length() + 1][s.length() + 1];

    for (int j = 0; j < t.length() + 1; j++) {
      for (int i = 0; i < s.length() + 1; i++) {
        if (j == 0) {
          count[j][i] = 1;
        } else if (i < j) {
          count[j][i] = 0;
        } else {
          count[j][i] = count[j][i - 1];
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            count[j][i] += count[j - 1][i - 1];
          }
        }
      }
    }
    return count[t.length()][s.length()];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.numDistinct("aabb", "aab"));
  }
}