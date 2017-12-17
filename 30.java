class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<Integer>();
    Map<String, Integer> dict = new HashMap<String, Integer>();

    for (String word : words) {
      dict.put(word, dict.getOrDefault(word, 0) + 1);
    }

    int len = words[0].length();
    int cnt = words.length;

    for (int i = 0; i < len; i++) {
      int left = i, count = 0;
      Map<String, Integer> cur = new HashMap<String, Integer>();

      for (int j = i; j <= s.length() - len; j += len) {
        String word = s.substring(j, j + len);
        if (dict.containsKey(word)) {
          cur.put(word, cur.getOrDefault(word, 0) + 1);
          count++;
          while (cur.get(word) > dict.get(word)) {
            String delword = s.substring(left, left + len);
            cur.put(delword, cur.get(delword) - 1);
            left += len;
            count--;
          }

          if (count == cnt) {
            ans.add(left);
            String delword = s.substring(left, left + len);
            cur.put(delword, cur.get(delword) - 1);
            left += len;
            count--;
          }
        } else {
          cur.clear();
          count = 0;
          left = j + len;
        }
      }
    }
    return ans;
  }

  public static void main(String[] argv) {
    Solution s = new Solution();
    String[] list = {"foo", "bar"};
    System.out.println(s.findSubstring("barfoothefoobarman", list));
  }
}