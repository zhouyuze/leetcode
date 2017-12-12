class Solution {
  public int romanToInt(String s) {
    int result = toInt(s.charAt(0));
    
    for (int i = 1; i < s.length(); i++) {
      if (toInt(s.charAt(i-1)) < toInt(s.charAt(i))) {
        result -= 2*toInt(s.charAt(i-1));
        result += toInt(s.charAt(i));
      } else {
        result += toInt(s.charAt(i));
      }
    }
    return result;
  }
  
  private int toInt(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }   
  }
  
  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.romanToInt("CDXCVI"));
  }
}