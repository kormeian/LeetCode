class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val edge = edges[0]
        return if (edge[0] == edges[1][0] || edge[0] == edges[1][1]) edge[0] else edge[1]
    }
}