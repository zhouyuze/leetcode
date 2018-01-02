public class Solution {
  class Transaction implements Comparable<Transaction> {
    Transaction prev;
    Transaction next;
    int buy;
    int sell;
    int loss;

    public Transaction(int buy, int sell, Transaction prev) {
      this.buy = buy;
      this.sell = sell;
      if (prev != null && prev.sell < sell) {
        loss = prev.sell - buy;
      } else {
        loss = sell - buy;
      }
      this.prev = prev;
      this.next = null;
    }

    @Override
    public int compareTo(Transaction o) {
      return loss - o.loss;
    }
  }

  public int maxProfit(int k, int[] prices) {
    PriorityQueue<Transaction> queue = new PriorityQueue<Transaction>();
    Transaction prev = null;
    int buyPrice = 0;
    int sellPrice = 0;
    int profit = 0;

    int count = 0;
    for (int i = 0; i < prices.length; i++) {
      int cur = prices[i];
      if (count == 0) {
        buyPrice = cur;
        count = 1;
      } else if (count == 1) {
        if (cur <= buyPrice) {
          buyPrice = cur;
        } else {
          count = 2;
          sellPrice = cur;
        }
      } else {
        if (cur >= sellPrice) {
          sellPrice = cur;

        } else {
          Transaction t = new Transaction(buyPrice, sellPrice, prev);
          queue.add(t);
          profit += sellPrice - buyPrice;

          if (prev != null) {
            prev.next = t;
          }
          prev = t;

          count = 1;
          buyPrice = cur;
        }
      }
    }

    if (count == 2) {
      Transaction t = new Transaction(buyPrice, sellPrice, prev);
      queue.add(t);
      profit += sellPrice - buyPrice;

      if (prev != null) {
        prev.next = t;
      }
      prev = t;
    }

    while (queue.size() > k) {
      Transaction moved = queue.remove();
      profit -= moved.loss;

      Transaction cur = moved.prev;
      if (cur != null) {
        cur.next = moved.next;
        if (cur.sell < moved.sell) {
          cur.sell = moved.sell;
          cur.loss = (cur.prev == null ? cur.sell : Math.min(cur.prev.sell, cur.sell)) - cur.buy;
          queue.remove(cur);
          queue.add(cur);
        }
      }

      Transaction curNext = moved.next;
      if (curNext != null) {
        curNext.prev = moved.prev;
        if (curNext.prev != null && curNext.prev.sell < curNext.sell) {
          curNext.loss = curNext.prev.sell - curNext.buy;
        } else {
          curNext.loss = curNext.sell - curNext.buy;
        }
        queue.remove(curNext);
        queue.add(curNext);
      }
    }

    return profit;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9};
    System.out.println(s.maxProfit(2, nums));
  }
}