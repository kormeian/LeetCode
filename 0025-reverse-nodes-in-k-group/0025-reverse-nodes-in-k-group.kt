/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head

        val dummy = ListNode(0)
        dummy.next = head
        var curr: ListNode? = dummy
        var nex: ListNode? = dummy
        var pre: ListNode? = dummy

        var count = 0
        while (curr?.next != null) {
            curr = curr.next
            count++
        }

        while (count >= k) {
            curr = pre?.next
            nex = curr?.next
            for (i in 1 until k) {
                curr?.next = nex?.next
                nex?.next = pre?.next
                pre?.next = nex
                nex = curr?.next
            }
            pre = curr
            count -= k
        }
        return dummy.next
    }
}