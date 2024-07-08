class Solution {
    fun minWindow(s: String, t: String): String {
        val tMap = mutableMapOf<Char, Int>()
        val sMap = mutableMapOf<Char, Int>()

        t.forEach { tMap[it] = tMap.getOrDefault(it, 0) + 1 }

        var left = 0
        var right = 0
        var count = 0
        var minLen = Int.MAX_VALUE
        var minStart = 0

        while (right < s.length) {
            val rightChar = s[right]
            if (tMap.containsKey(rightChar)) {
                sMap[rightChar] = sMap.getOrDefault(rightChar, 0) + 1
                if (sMap[rightChar] == tMap[rightChar]) count++
            }

            while (count == tMap.size) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1
                    minStart = left
                }

                val leftChar = s[left]
                if (tMap.containsKey(leftChar)) {
                    sMap[leftChar] = sMap[leftChar]!! - 1
                    if (sMap[leftChar]!! < tMap[leftChar]!!) count--
                }

                left++
            }

            right++
        }

        return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLen)
    }
}