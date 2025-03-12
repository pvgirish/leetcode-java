public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if the list is empty or has only one node
        }

        ListNode hare = head; // Fast pointer
        ListNode tortoise = head; // Slow pointer
        ListNode third = null; // Third pointer to help find the start of the cycle

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next; // Move hare two steps
            tortoise = tortoise.next; // Move tortoise one step

            if (hare == tortoise) { // Cycle detected
                third = head;
                while (third != tortoise) {
                    third = third.next;
                    tortoise = tortoise.next;
                }

                return third;

            }
        }
        return null;

    }
}