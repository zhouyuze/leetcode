class Solution {
  public String intToRoman(int num) {
    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    Integer[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String result = "";
    while (num > 0) {
      for (int i = 0; i < number.length; i++) {
        if (num >= number[i]) {
          result = result + roman[i];
          num -= number[i];
          break;
        }
      }
    }
    return result;
  }
  
  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.intToRoman(496));
  }
}