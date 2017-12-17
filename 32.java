class Solution {
  public int longestValidParentheses(String s) {
    Stack<Integer> leftParenthese = new Stack<Integer>();
    int[] longestValid = new int[s.length()];
    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        longestValid[i] = 0;
        leftParenthese.push(i);

      } else {
        int len = 0;
        if (!leftParenthese.isEmpty()) {
          int correspond = leftParenthese.pop();
          len = i - correspond + 1;
          if (correspond > 0) {
            len += longestValid[correspond - 1];
          }
        }

        longestValid[i] = len;
        max = Math.max(len, max);
      }
    }

    return max;
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.longestValidParentheses("()(()"));
  }
}