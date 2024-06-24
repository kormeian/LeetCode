class Solution {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        val n = nums.size
        val flip = IntArray(n)
        var answer = 0
        var isFlip = 0

        for (i in nums.indices) {
            if (i >= k) {
                isFlip = isFlip xor flip[i - k]
            }
            if (isFlip % 2 == nums[i]) {
                if (i + k > n) {
                    return -1
                }
                flip[i] = 1
                isFlip = isFlip xor 1
                answer++
            }
        }

        return answer
    }
}