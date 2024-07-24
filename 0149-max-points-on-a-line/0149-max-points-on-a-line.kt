class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        val n = points.size
        if (n <= 2) return n
        var maxCount = 0
        for (i in 0 until n) {
            val map = mutableMapOf<String, Int>()
            var samePoint = 0
            var localMax = 0
            for (j in i + 1 until n) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    samePoint++
                    continue
                }
                val dx = points[j][0] - points[i][0]
                val dy = points[j][1] - points[i][1]
                val gcd = gcd(dx, dy)
                val key = "${dx / gcd},${dy / gcd}"
                map[key] = map.getOrDefault(key, 0) + 1
                localMax = maxOf(localMax, map[key]!!)
            }
            maxCount = maxOf(maxCount, localMax + samePoint + 1)
        }
        return maxCount
    }
    
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}