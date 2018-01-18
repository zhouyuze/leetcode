public class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] tail = new int[nums.length];
    int size = 0;
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tail[m] < x) {
          i = m + 1;
        } else {
          j = m;
        }
      }
      tail[i] = x;
      if (i == size)
        size++;
    }
    return size;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(s.lengthOfLIS(a));
  }
}