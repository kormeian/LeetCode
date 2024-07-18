class Solution {
    fun totalNQueens(n: Int): Int {
        val board = Array(n) { CharArray(n) { '.' } }
        var count = 0
        fun isNotUnderAttack(row: Int, col: Int): Boolean {
            for (i in 0 until row) {
                if (board[i][col] == 'Q') return false
                val diff = row - i
                if (col - diff >= 0 && board[i][col - diff] == 'Q') return false
                if (col + diff < n && board[i][col + diff] == 'Q') return false
            }
            return true
        }
        fun backtrack(row: Int) {
            if (row == n) {
                count++
                return
            }
            for (col in 0 until n) {
                if (isNotUnderAttack(row, col)) {
                    board[row][col] = 'Q'
                    backtrack(row + 1)
                    board[row][col] = '.'
                }
            }
        }
        backtrack(0)
        return count
    }
}