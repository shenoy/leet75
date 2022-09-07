import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println(new ReverseLinkedList().reverseList(ln1));
    }
}
