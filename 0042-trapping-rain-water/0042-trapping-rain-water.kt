class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        var result = 0
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]
                } else {
                    result += leftMax - height[left]
                }
                left++
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]
                } else {
                    result += rightMax - height[right]
                }
                right--
            }
        }
        return result
    }
}