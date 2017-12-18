package leetcode;

class Solution {
  public String minWindow(String s, String t) {
    int[] count = new int[256], cur = new int[256];
    int sum = t.length(), curSum = 0;
    String minWindow = "";
    boolean found = false;

    for (char c : t.toCharArray()) {
      count[c]++;
    }

    int point1 = 0, point2 = 0;

    while (point1 < s.length() || found) {
      if (!found) {
        char c = s.charAt(point1);
        cur[c]++;
        point1++;
        if (cur[c] <= count[c]) {
          curSum++;
          if (curSum == sum) {
            found = true;
          }
        }

      } else {
        if (minWindow.equals("") || minWindow.length() > point1 - point2) {
          minWindow = s.substring(point2, point1);
        }
        char c = s.charAt(point2);
        cur[c]--;
        point2++;
        if (cur[c] < count[c]) {
          found = false;
          curSum--;
        }
      }
    }

    return minWindow;
  }

  public static void main(String[] argv) {
    // System.out.println(Integer.valueOf('A'));
    Solution s = new Solution();
    System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
  }
}
