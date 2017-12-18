class Solution {
  public int minDistance(String word1, String word2) {
    int[][] distance = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        if (i == 0 || j == 0) {
          distance[i][j] = i + j;
        } else {
          int min = distance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
          min = Math.min(min, distance[i][j - 1] + 1);
          min = Math.min(min, distance[i - 1][j] + 1);
          distance[i][j] = min;
        }
      }
    }
    return distance[word1.length()][word2.length()];
  }
}