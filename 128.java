public class Solution {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> consecutive = new HashMap<Integer, Integer>();
    int max = 0;
    for (int num : nums) {
      if (consecutive.containsKey(num)) {
        continue;
      }
      int before = consecutive.getOrDefault(num - 1, 0),
          after = consecutive.getOrDefault(num + 1, 0), value = before + after + 1;
      consecutive.put(num, value);
      consecutive.put(num - before, value);
      consecutive.put(num + after, value);
      max = Math.max(max, value);
    }
    return max;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {100, 4, 200, 1, 3, 2};
    System.out.println(s.longestConsecutive(nums));
  }
}