class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        val rotateSteps = k % n
        reverse(nums, 0, n - 1)
        reverse(nums, 0, rotateSteps - 1)
        reverse(nums, rotateSteps, n - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var startTmp = start
        var endTmp = end
        while (startTmp < endTmp) {
            val temp = nums[startTmp]
            nums[startTmp] = nums[endTmp]
            nums[endTmp] = temp
            startTmp++
            endTmp--
        }
    }
}