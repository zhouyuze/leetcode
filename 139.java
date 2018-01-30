package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<String>();
    boolean[][] breakable = new boolean[s.length()][s.length()];
    words.addAll(wordDict);
    for (int len = 1; len <= s.length(); len++) {
      for (int start = 0; start + len <= s.length(); start++) {
        int end = start + len;
        boolean result = false;
        String subStr = s.substring(start, end);
        if (words.contains(subStr)) {
          breakable[start][end - 1] = true;
          continue;
        }
        for (int sep = start + 1; sep < end; sep++) {
          if (breakable[start][sep - 1] && breakable[sep][end - 1]) {
            result = true;
            break;
          }
        }
        breakable[start][end - 1] = result;
      }
    }
    return breakable[0][s.length() - 1];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "leetcodee";
    List<String> dict = new ArrayList<String>();
    dict.add("leet");
    dict.add("code");
    System.out.println(s.wordBreak(str, dict));
  }
}
