class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        val n = prices.size
        val leftProfit = IntArray(n)
        val rightProfit = IntArray(n)

        var minPrice = prices[0]
        for (i in 1 until n) {
            leftProfit[i] = maxOf(leftProfit[i - 1], prices[i] - minPrice)
            minPrice = minOf(minPrice, prices[i])
        }

        var maxPrice = prices[n - 1]
        for (i in n - 2 downTo 0) {
            rightProfit[i] = maxOf(rightProfit[i + 1], maxPrice - prices[i])
            maxPrice = maxOf(maxPrice, prices[i])
        }

        var maxProfit = 0
        for (i in 0 until n) {
            maxProfit = maxOf(maxProfit, leftProfit[i] + rightProfit[i])
        }

        return maxProfit
    }
}
