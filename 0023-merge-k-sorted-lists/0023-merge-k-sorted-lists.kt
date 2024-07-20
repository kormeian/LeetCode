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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val head = ListNode(0)
        var current = head
        val heap = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
        lists.forEach { if (it != null) heap.add(it) }
        while (heap.isNotEmpty()) {
            val node = heap.poll()
            current.next = node
            current = current.next!!
            if (node.next != null) heap.add(node.next)
        }
        return head.next
    }
}