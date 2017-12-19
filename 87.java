class Solution {
  public boolean isScramble(String s1, String s2) {
    String rs2 = new StringBuilder(s2).reverse().toString();
    return isBreakable(s1, s2) || isBreakable(s1, rs2);
  }

  private boolean isBreakable(String s1, String s2) {
    int[] dict = new int[256];
    int count = 0, breakPos = 0;

    if (s1.equals(s2)) {
      return true;
    } else if (s1.length() != s2.length()) {
      return false;
    }

    for (int i = 0; i < s1.length(); i++) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);

      if (c1 != c2) {
        dict[c1]++;
        if (dict[c1] == 0) {
          count--;
        } else if (dict[c1] == 1) {
          count++;
        }

        dict[c2]--;
        if (dict[c2] == 0) {
          count--;
        } else if (dict[c2] == -1) {
          count++;
        }
      }

      if (count == 0) {
        breakPos = i + 1;
        break;
      }
    }

    if (breakPos != s1.length() && breakPos != 0) {
      String s1Front = s1.substring(0, breakPos);
      String s2Front = s2.substring(0, breakPos);
      String rs2Front = new StringBuilder(s2Front).reverse().toString();
      boolean front = isBreakable(s1Front, s2Front) || isBreakable(s1Front, rs2Front);

      if (!front) {
        return false;
      }

      String s1Behind = s1.substring(breakPos);
      String s2Behind = s2.substring(breakPos);
      String rs2Behind = new StringBuilder(s2Behind).reverse().toString();
      boolean behind = isBreakable(s1Behind, s2Behind) || isBreakable(s1Behind, rs2Behind);

      if (!behind) {
        return false;
      }

      return true;

    } else {
      return false;
    }
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.isScramble("aa", "ab"));
  }
}