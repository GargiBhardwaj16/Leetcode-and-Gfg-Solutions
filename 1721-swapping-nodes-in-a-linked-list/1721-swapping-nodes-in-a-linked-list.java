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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode len = head;
        int length = 0;
        while(len!=null){
            len = len.next;
            length++;
        }
        ListNode curr1 = head;
        ListNode curr2 = head;

        int l = length-k;
        while(k-->1){
            curr1 = curr1.next;
        }
        while(l-->0){
            curr2 = curr2.next;
        }
        if(curr1==curr2) return head;
       
        curr1.val = curr1.val + curr2.val;
        curr2.val = curr1.val - curr2.val;
        curr1.val = curr1.val - curr2.val;
       
        return head;
    }
}