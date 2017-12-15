public class Solution {
  public String simplifyPath(String path) {
    String[] dirs = path.split("/");

    Stack<String> stack = new Stack<String>();

    for (String dir : dirs) {
      if (dir.equals("") || dir.equals(".")) {
        continue;
      } else if (dir.equals("..")) {
        if (!stack.empty()) {
          stack.pop();
        }
      } else {
        stack.push(dir);
      }
    }

    if (!stack.empty()) {
      String result = "";
      while (!stack.empty()) {
        result = "/" + stack.pop() + result;
      }
      return result;
    } else {
      return "/";
    }
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.simplifyPath("/home/"));
  }
}