/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
         if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            while (!stack.isEmpty() && stack.peek().val < current.val) {
                stack.pop();
            }
            stack.push(current);
            current = current.next;
        }
        ListNode newHead = stack.isEmpty() ? null : stack.firstElement();
        ListNode newCurrent = newHead;
        while (!stack.isEmpty()) {
            newCurrent.next = stack.remove(0); 
            newCurrent = newCurrent.next;
        }
        if (newCurrent != null) newCurrent.next = null; 
        return newHead;
    }
}