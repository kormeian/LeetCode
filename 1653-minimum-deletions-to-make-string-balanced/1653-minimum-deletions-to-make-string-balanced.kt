class Solution {
    fun minimumDeletions(s: String): Int {
        var aCount = 0
        var bCount = 0

        for (char in s) {
            if (char == 'a') {
                aCount++
            }
        }
        var minDeletions = aCount

        for (char in s) {
            if (char == 'a') {
                aCount--
            } else {
                bCount++
            }
            minDeletions = minOf(minDeletions, aCount + bCount)
        }

        return minDeletions
    }
}