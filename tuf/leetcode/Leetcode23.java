package leetcode;

public class Leetcode23 {
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        for(ListNode head : lists){
            if(head!=null) minHeap.offer(head);
        }
      stNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            if(smallest.next!=null) minHeap.offer(smallest.next);
        }
        return dummy.next;
    }
}
