class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val n = profits.size
        val arr = Array(n) { Pair(profits[it], capital[it]) }
        arr.sortBy { it.second }
        val pq = PriorityQueue<Int>()
        var i = 0
        var money = w
        repeat(k) {
            while (i < n && arr[i].second <= money) {
                pq.add(-arr[i].first)
                i++
            }
            if (pq.isNotEmpty()) {
                money -= pq.poll()
            }
        }
        return money
    }
}