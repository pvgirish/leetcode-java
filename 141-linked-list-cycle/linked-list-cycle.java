/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode hare = head; 
        ListNode tortoise = head;
    
        while(hare.next != null && hare.next.next != null)
        {
            
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise)
            return true;
            
        }

        hare = null; 
        tortoise = null;
        return false;
    }
}