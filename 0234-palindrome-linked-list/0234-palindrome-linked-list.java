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
     public static ListNode reverseList(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode curr=temp;
            temp=temp.next;
            curr.next=prev;
            prev=curr;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newHead=reverseList(slow.next);
        ListNode temp1=head;
        ListNode temp=newHead;
        while(temp!=null){
            if(temp.val!=temp1.val){
                return false;
            }
            else{
                temp1=temp1.next;
                temp=temp.next;
            }
        }
        return true;
    }
}