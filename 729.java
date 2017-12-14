public class MyCalendar {
  class Tree {
    int start;
    int end;
    Tree left;
    Tree right;

    Tree(int start, int end) {
      this.start = start;
      this.end = end;
      left = null;
      right = null;
    }
  }

  public Tree calendar;

  public MyCalendar() {
    calendar = null;
  }

  public boolean book(int start, int end) {
    if (calendar == null) {
      calendar = new Tree(start, end);
      return true;
    }

    Tree current = calendar;
    Tree prev = null;

    while (current != null) {
      if (end <= current.start) {
        prev = current;
        current = current.left;
      } else if (start >= current.end) {
        prev = current;
        current = current.right;
      } else {
        return false;
      }
    }
    
    if (end <= prev.start) {
      prev.left = new Tree(start, end);
    } else {
      prev.right = new Tree(start, end);
    }
    
    return true;
  }
  
  public static void main(String[] argv) {
    MyCalendar obj = new MyCalendar();
    System.out.println(obj.book(25,32));
    System.out.println(obj.book(19,25));
    System.out.println(obj.book(20,30));
  }
}