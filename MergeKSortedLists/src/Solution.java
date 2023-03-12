import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        if(lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }

        return dummy.next;

    }

    public static void main(String[] args){
        // [[1,4,5],[1,3,4],[2,6]]
        Solution sol = new Solution();
        List<ListNode> node = new ArrayList<ListNode>();
        node.add(new ListNode(1, new ListNode(4, new ListNode(5))));
        node.add(new ListNode(1, new ListNode(3, new ListNode(4))));
        node.add(new ListNode(2, new ListNode(6)));

        System.out.println(sol.mergeKLists(node.toArray(new ListNode[0])).val);
    }
}
