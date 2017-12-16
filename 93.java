public class Solution {
  List<String> result = new ArrayList<String>();

  public List<String> restoreIpAddresses(String s) {
    restoreIp("", s, 4);
    return result;
  }

  public void restoreIp(String cur, String remain, int depth) {
    if (depth == 0 || remain.equals("")) {
      if (depth == 0 && remain.equals("")) {
        result.add(cur.substring(0, cur.length() - 1));
      } else {
        return;
      }

    } else {
      if (remain.charAt(0) == '0') {
        restoreIp(cur + "0.", remain.substring(1), depth - 1);
        return;
      }

      for (int i = 0; i < Math.min(3, remain.length()); i++) {
        String part = remain.substring(0, i + 1);
        if (Integer.parseInt(part) > -1 && Integer.parseInt(part) < 256) {
          restoreIp(cur + part + ".", remain.substring(i + 1), depth - 1);
        }
      }
    }
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    System.out.println(s.restoreIpAddresses("010010"));
  }
}
