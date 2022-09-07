

public class MergeTwoSortedLists {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            LinkedList merged = new LinkedList();

               while(list1!=null){
                merged.append(list1.val);
                list1 = list1.next;
            }

            while(list2!=null){
                merged.append(list2.val);
                list2 = list2.next;
            }

            merged.head = merged.mergeSort(merged.head);
            System.out.print("\n Sorted Linked List is: \n");
           merged.printList();

         return merged.head;
        }


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        //Create tempNode to have a reference to empty node.
        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;

        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            //If both lists != null, add the lesser value to currentNode
            if (val1 <= val2) {
                currentNode.next = list1;
                currentNode = currentNode.next;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                currentNode = currentNode.next;
                list2 = list2.next;
            }
        }

        //In case one list ends before the other, put the remaining nodes into currentNode.
        while (list1 != null) {
            currentNode.next = list1;
            currentNode = currentNode.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            currentNode.next = list2;
            currentNode = currentNode.next;
            list2 = list2.next;
        }


        //tempNode is an empty node, so the first node with a value is tempNode.next
        return tempNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList{
    ListNode head;

    public void append(int new_data)
    {

        ListNode new_ListNode = new ListNode(new_data);
        if (head == null)
        {
            head = new ListNode(new_data);
            return;
        }
        new_ListNode.next = null;
        ListNode last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_ListNode;
        return;
    }

    public void printList()
    {
        ListNode n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }


    ListNode sortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }


    ListNode mergeSort(ListNode h)
    {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        ListNode middle = getMiddle(h);
        ListNode nextofmiddle = middle.next;

        // set the next of middle ListNode to null
        middle.next = null;

        // Apply mergeSort on left list
        ListNode left = mergeSort(h);

        // Apply mergeSort on right list
        ListNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }


    // Utility function to get the middle of the linked list
    public static ListNode getMiddle(ListNode head)
    {
        if (head == null)
            return head;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



}


