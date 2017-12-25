public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    Map<Integer, Set<List<Integer>>> dict = new HashMap<Integer, Set<List<Integer>>>();
    for (int num : candidates) {
      Set<List<Integer>> lists = null;
      for (int j = target - num; j > 0; j--) {
        lists = dict.get(j);
        if (lists != null) {
          for (List<Integer> list : lists) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(num);
            int sum = j + num;
            lists = dict.get(sum);

            if (lists != null) {
              lists.add(newList);
            } else {
              lists = new HashSet<List<Integer>>();
              lists.add(newList);
              dict.put(j + num, lists);
            }
          }
        }
      }

      if (dict.containsKey(num)) {
        lists = dict.get(num);
        lists.add(new ArrayList<Integer>(Collections.nCopies(1, num)));
      } else {
        lists = new HashSet<List<Integer>>();
        lists.add(new ArrayList<Integer>(Collections.nCopies(1, num)));
        dict.put(num, lists);
      }
    }
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (dict.containsKey(target)) {
      result.addAll(dict.get(target));
    }
    return result;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {10, 1, 2, 7, 6, 1, 5};
    s.combinationSum2(nums, 8);
  }
}