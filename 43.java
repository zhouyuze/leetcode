class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    
    num1 = new StringBuilder(num1).reverse().toString();
    num2 = new StringBuilder(num2).reverse().toString();
    int accumulate = 0;
    StringBuilder result = new StringBuilder();

    for (int pos = 0; pos < num1.length() + num2.length() - 1; pos++) {
      int num1Pos = 0;
      int num2Pos = 0;

      while (num1Pos < num1.length() && num1Pos <= pos) {
        num2Pos = pos - num1Pos;
        if (num2Pos >= num2.length()) {
          num1Pos++;
          continue;
        }
        accumulate += Integer.parseInt(num1.substring(num1Pos, num1Pos+1)) * Integer.parseInt(num2.substring(num2Pos, num2Pos+1));
        num1Pos++;
      }
      
      result.append(String.valueOf(accumulate % 10));
      accumulate /= 10;
    }
    
    if (accumulate != 0) {
      result.append(String.valueOf(accumulate));
    }
    
    return result.reverse().toString();
  }


  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.multiply("789", "654"));
  }
}
