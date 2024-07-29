class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        val n = prices.size
        if (k >= n / 2) {
            var profit = 0
            for (i in 1 until n) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1]
                }
            }
            return profit
        }
        val dp = Array(k + 1) { IntArray(n) }
        for (i in 1..k) {
            var maxDiff = -prices[0]
            for (j in 1 until n) {
                dp[i][j] = maxOf(dp[i][j - 1], prices[j] + maxDiff)
                maxDiff = maxOf(maxDiff, dp[i - 1][j] - prices[j])
            }
        }
        return dp[k][n - 1]
    }
}