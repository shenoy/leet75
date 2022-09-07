import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1,new ListNode(2, new ListNode(4, null)));
        ListNode ln2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode ln3 = new ListNode(5,null);
        ListNode ln4 = new ListNode(0,null);
        System.out.println(new MergeTwoSortedLists().mergeTwoLists2(ln3 , ln1));
    }
}
