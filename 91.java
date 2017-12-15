public class Solution {
  public int numDecodings(String s) {
    
    if (s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    
    int current = 1, prev = 1, next;
    
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == '0') {
        if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
          return 0;
        }
        int tmp = prev;
        prev = current;
        current = tmp;
        
      } else if (s.charAt(i - 1) == '1') {
        next = current + prev;
        prev = current;
        current = next;
        
      } else if (s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
        next = current + prev;
        prev = current;
        current = next;
        
      } else {
        prev = current;
      }
    }
    return current;
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.numDecodings("26724"));
  }
}