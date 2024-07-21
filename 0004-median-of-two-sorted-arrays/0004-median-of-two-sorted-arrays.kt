class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double { 
        val merged = nums1 + nums2
        merged.sort()
        val n = merged.size
        return if (n % 2 == 0) {
            (merged[n / 2 - 1] + merged[n / 2]) / 2.0
        } else {
            merged[n / 2].toDouble()
        }
    }
}