public class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> ans = new ArrayList<Interval>();
    int start = newInterval.start, end = newInterval.end;
    for (Interval interval : intervals) {
      if (interval.end < start) {
        ans.add(interval);
      } else if (interval.start > end) {
        ans.add(new Interval(start, end));
        ans.add(interval);
        start = Integer.MAX_VALUE;
        end = Integer.MAX_VALUE;
      } else {
        start = Math.min(start, interval.start);
        end = Math.max(end, interval.end);
      }
    }
    if (start != Integer.MAX_VALUE) {
      ans.add(new Interval(start, end));
    }
    return ans;
  }
}