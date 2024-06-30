class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size

        var i = 1
        var count = 1

        for (j in 1 until nums.size) {
            if (nums[j] == nums[j - 1]) {
                count++
            } else {
                count = 1
            }

            if (count <= 2) {
                nums[i] = nums[j]
                i++
            }
        }

        return i
    }
}