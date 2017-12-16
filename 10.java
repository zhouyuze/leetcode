class Solution {
  public boolean isMatch(String s, String p) {
    StringBuilder letter = new StringBuilder();
    int[] times = new int[p.length()];
    int point = 0;

    for (char c : p.toCharArray()) {
      if (c != '*') {
        letter.append(c);
        times[point++] = 1;
      } else {
        times[point - 1] = 0;
      }
    }
    p = letter.toString();

    boolean[] prev = new boolean[s.length() + 1];
    boolean[] curr = new boolean[s.length() + 1];

    for (int i = 0; i < p.length() + 1; i++) {
      for (int j = 0; j < s.length() + 1; j++) {
        if (i == 0) {
          if (j == 0) {
            curr[j] = true;
          } else {
            curr[j] = false;
          }
          continue;
        }

        if (j == 0) {
          if (prev[j] && times[i - 1] == 0) {
            curr[j] = true;
          } else {
            curr[j] = false;
          }
          continue;
        }

        if (curr[j - 1] && times[i - 1] == 0
            && (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.')) {
          curr[j] = true;
        } else if (prev[j] && times[i - 1] == 0) {
          curr[j] = true;
        } else if (prev[j - 1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1))) {
          curr[j] = true;
        } else {
          curr[j] = false;
        }
      }
      boolean[] tmp = prev;
      prev = curr;
      curr = tmp;
    }

    return prev[s.length()];
  }
}