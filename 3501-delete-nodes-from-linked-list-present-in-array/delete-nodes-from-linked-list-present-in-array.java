class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums)
            set.add(i);
        
        while(head!=null && set.contains(head.val)) {
            head = head.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current != null && current.next != null) {
            if (set.contains(current.next.val)) {

                current.next = current.next.next;
            } else {

                current = current.next;
            }
        }

        return dummy.next;
    }
}