class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Map<Integer, Set<List<Integer>>> dict = new HashMap<Integer, Set<List<Integer>>>();
    for (int num : candidates) {
      for (int i = 1; num * i <= target; i++) {
        Set<List<Integer>> set = null;
        for (int j = 1; j <= target - num * i; j++) {
          set = dict.get(j);
          if (set != null) {
            for (List<Integer> list : set) {
              List<Integer> newList = new ArrayList<Integer>(list);
              newList.addAll(Collections.nCopies(i, num));
              int sum = j + num * i;
              set = dict.get(sum);
              if (set != null) {
                set.add(newList);
              } else {
                set = new HashSet<List<Integer>>();
                set.add(newList);
                dict.put(j + num * i, set);
              }
            }
          }
        }
        
        if (dict.containsKey(num * i)) {
          set = dict.get(num * i);
          set.add(Collections.nCopies(i, num));
        } else {
          set = new HashSet<List<Integer>>();
          set.add(Collections.nCopies(i, num));
          dict.put(num * i, set);
        }
      }
    }
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (dict.containsKey(target)) {
      result.addAll(dict.get(target));
    }
    return result;
  }
}