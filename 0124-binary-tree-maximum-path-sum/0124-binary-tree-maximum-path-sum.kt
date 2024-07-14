/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var max = Int.MIN_VALUE
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            val left = dfs(node.left).coerceAtLeast(0)
            val right = dfs(node.right).coerceAtLeast(0)
            max = max.coerceAtLeast(left + right + node.`val`)
            return node.`val` + left.coerceAtLeast(right)
        }
        dfs(root)
        return max
    }
}