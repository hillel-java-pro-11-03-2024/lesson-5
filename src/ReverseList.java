
public class ReverseList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    ListNode i = reverseList(head);
    while(i != null) {
      System.out.print(i.val + " ");
      i = i.next;
    }
  }

  public static ListNode reverseList(ListNode head) {
    return iter(null, head);
  }

  private static ListNode iter(ListNode prev, ListNode curr) {
    if (curr == null) {
      return prev;
    }
    ListNode next = curr.next;
    curr.next = prev;
    return iter(curr, next);
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
