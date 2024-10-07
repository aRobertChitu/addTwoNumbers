//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list =  new ListNode();
        int value = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        list.val= value;
        list.next = findNext(l1.next, l2.next, carry);

        return list;
    }

    public static ListNode findNext(ListNode l1, ListNode l2, int c){
        if((l1 == null && l2 == null) && c==0){
            return null;
        } else if ((l1 == null && l2 == null) && c==1){
            return new ListNode(1);
        }
        ListNode list =  new ListNode();
        int value = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + c) % 10;
        int carry = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + c) / 10;
        list.val= value;
        if(l1 == null){
            list.next = findNext(null, l2.next, carry);
        }else if( l2 == null){
            list.next = findNext(l1.next, null, carry);
        }else{
            list.next = findNext(l1.next, l2.next, carry);
        }
        return list;
    }
}