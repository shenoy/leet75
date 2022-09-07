import java.awt.*;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.* *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Runtime: 45 ms, faster than 12.66% of Java online submissions for Reverse Linked List.
 * Memory Usage: 42.8 MB, less than 67.34% of Java online submissions for Reverse Linked List.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        int count = getCount(head);
        LinkedList2 ll = new LinkedList2(null);
        while(count>0){
            ListNode last = getLast(head,count);
            if(ll.head==null){
                ll.head=last;
            }else{
                ll.append(last);
            }
            count --;
        }
        printList(ll.head);
        return ll.head;
    }

    public ListNode getLast(ListNode head, int count){
        for(int i=count;i>1;i--){
            head = head.next;
        }
        head.next=null;
        return head;
    }


    public int getCount(ListNode head){
        int count =0;
        while(head!=null){
            head = head.next;
            count++;
        }
        System.out.println(count);
        return count;
    }

    public void printList(ListNode h){
        while(h!=null){
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}

class LinkedList2 {
    public ListNode head;
    public LinkedList2(ListNode head){
        this.head=head;
    }
    public void append(ListNode y){
        ListNode newNode = new ListNode(y.val, null);
        if(head==null){
            this.head = newNode;
        }
        ListNode temp = this.head;
        while(temp.next!=null){
          temp = temp.next;
        }
        temp.next=newNode;
    }
}

