public class Solution {
  class ArrayIndexComparator implements Comparator<Integer> {
    int[] height;

    public ArrayIndexComparator(int[] height) {
      this.height = height;
    }

    public Integer[] createIndex() {
      return IntStream.range(0, height.length).boxed().toArray(Integer[]::new);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      return height[o2] - height[o1];
    }

  }

  class Tree {
    int left, right, value;
    Tree leftNode = null, rightNode = null;

    Tree(int left, int right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
    }
  }

  public int trap(int[] height) {
    if (height.length < 2) {
      return 0;
    }

    ArrayIndexComparator cmp = new ArrayIndexComparator(height);
    Integer[] index = cmp.createIndex();
    int result = 0;
    Arrays.sort(index, cmp);

    Tree root = null;
    for (int i = 0; i < index.length; i++) {
      if (i == 0) {
        int left = Math.min(index[i], index[i + 1]);
        int right = Math.max(index[i], index[i + 1]);
        root = new Tree(left, right, height[index[++i]]);

        for (int p = left + 1; p < right; p++) {
          result += root.value - height[p];
        }

      } else {
        int pos = index[i];
        Tree prev = null, point = root;
        while (point != null) {
          if (pos > point.left && pos < point.right) {
            break;
          } else if (pos < point.left) {
            prev = point;
            point = point.leftNode;
          } else {
            prev = point;
            point = point.rightNode;
          }
        }

        if (point == null) {
          if (pos < prev.left) {
            point = new Tree(pos, prev.left, height[pos]);
            prev.leftNode = point;
          } else {
            point = new Tree(prev.right, pos, height[pos]);
            prev.rightNode = point;
          }

          for (int p = point.left + 1; p < point.right; p++) {
            result += point.value - height[p];
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(s.trap(height));
  }
}
