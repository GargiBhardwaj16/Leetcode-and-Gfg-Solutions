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
public class Solution {
    public ListNode doubleIt(ListNode head) {
        // Reverse the linked list
        ListNode reversedList = reverseList(head);
        // Initialize variables to track carry and previous node
        int carry = 0;
        ListNode current = reversedList, previous = null;

        // Traverse the reversed linked list
        while (current != null) {
            // Calculate the new value for the current node
            int newValue = current.val * 2 + carry;
            // Update the current node's value
            current.val = newValue % 10;
            // Update carry for the next iteration
            if (newValue > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            // Move to the next node
            previous = current;
            current = current.next;
        }

        // If there's a carry after the loop, add an extra node
        if (carry != 0) {
            ListNode extraNode = new ListNode(carry);
            previous.next = extraNode;
        }

        // Reverse the list again to get the original order
        ListNode result = reverseList(reversedList);

        return result;
    }

    // Method to reverse the linked list
    public ListNode reverseList(ListNode node) {
        ListNode previous = null, current = node, nextNode;

        // Traverse the original linked list
        while (current != null) {
            // Store the next node
            nextNode = current.next;
            // Reverse the link
            current.next = previous;
            // Move to the next nodes
            previous = current;
            current = nextNode;
        }
        // Previous becomes the new head of the reversed list
        return previous;
    }
}
/*class Solution {
    public String calsum(ListNode head){
        StringBuilder sb=new StringBuilder();
        ListNode temp=head;
        while(temp!=null){
            sb.append(temp.val);
            temp=temp.next;
        }
        return sb.toString();
    }
    
    public ListNode doubleIt(ListNode head) {
        ListNode temp = head;
        ListNode nHead = new ListNode(0);
        ListNode prev = nHead;
        int c = 0;

        while (temp != null) {
            int sum = temp.val * 2 + c;
            c = sum / 10;
            sum %= 10;

            prev.next = new ListNode(sum);
            prev = prev.next;

            temp = temp.next;
        }

        if (c != 0) {
            prev.next = new ListNode(c% 10);
            c/=10;
            prev=prev.next;
        }

        return nHead.next;
    }
}*/