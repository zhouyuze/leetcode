public class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<String>(wordDict);
    List<List<Integer>> wordEnd = new ArrayList<List<Integer>>(s.length());

    for (int i = 0; i < s.length(); i++) {
      wordEnd.add(new ArrayList<Integer>());
    }

    for (int i = s.length() - 1; i >= 0; i--) {
      List<Integer> sentance = wordEnd.get(i);
      for (int j = i + 1; j < s.length(); j++) {
        if (dict.contains(s.substring(i, j)) && !wordEnd.get(j).isEmpty()) {
          sentance.add(j);
        }
      }
      if (dict.contains(s.substring(i))) {
        sentance.add(s.length());
      }
    }


    return getSentance(s, 0, wordEnd);
  }

  private List<String> getSentance(String s, int index, List<List<Integer>> wordEnd) {
    List<String> ans = new ArrayList<String>();
    for (int breakPos : wordEnd.get(index)) {
      if (breakPos == s.length()) {
        ans.add(s.substring(index));
      } else {
        for (String sub : getSentance(s, breakPos, wordEnd)) {
          ans.add(s.substring(index, breakPos) + " " + sub);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str =
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    String[] dict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
        "aaaaaaaaa", "aaaaaaaaaa"};
    String str1 = "catsanddog";
    String[] dict1 = {"cat", "cats", "and", "sand", "dog"};
    System.out.println(s.wordBreak(str, Arrays.asList(dict)));
  }
}