public class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    int result = 0;
    List<Map<Integer, Integer>> arrays = new ArrayList<Map<Integer, Integer>>();
    for (int i = 0; i < A.length; i++) {
      Map<Integer, Integer> myArray = new HashMap<Integer, Integer>();
      arrays.add(myArray);
      int diff;
      for (int j = 0; j < i; j++) {
        if ((long) A[i] - A[j] > Integer.MAX_VALUE)
          continue;
        if ((long) A[i] - A[j] < Integer.MIN_VALUE)
          continue;
        diff = A[i] - A[j];
        int length = arrays.get(j).getOrDefault(diff, 1) + 1;
        result += (length - 2);
        int value = myArray.getOrDefault(diff, 1);
        myArray.put(diff, value + length - 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {2, 2, 2, 2};
    System.out.println(s.numberOfArithmeticSlices(nums));
  }
}