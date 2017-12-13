class Solution {
  public List<String> generateParenthesis(int n) {
    ArrayList<String> result = new ArrayList<String>();
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> leftCount = new Stack<Integer>();
    Stack<Integer> rightCount = new Stack<Integer>();

    char[] parenthesis = new char[n * 2];
    int length = 0;
    int curLeft = 0;
    int curRight = 0;

    do {
      while (curLeft < n) {
        parenthesis[length++] = '(';
        if (curLeft > curRight) {
          stack.push(length - 1);
          leftCount.push(curLeft);
          rightCount.push(curRight);
        }
        curLeft++;
      }

      while (curRight < n) {
        parenthesis[length++] = ')';
        curRight++;
      }

      result.add(String.valueOf(parenthesis));

      if (!stack.isEmpty()) {
        length = stack.pop();
        curLeft = leftCount.pop();
        curRight = rightCount.pop() + 1;
        parenthesis[length++] = ')';
      } else {
        length = 0;
      }

    } while (length != 0);
    return result;
  }
}