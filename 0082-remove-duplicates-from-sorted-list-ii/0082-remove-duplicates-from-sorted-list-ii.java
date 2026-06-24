class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check if current node is a duplicate
            if (curr.next != null && curr.val == curr.next.val) {
                int duplicateVal = curr.val;

                // Skip all nodes with the duplicate value
                while (curr != null && curr.val == duplicateVal) {
                    curr = curr.next;
                }

                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}