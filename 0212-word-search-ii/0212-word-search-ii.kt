class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie()
        words.forEach { trie.insert(it) }
        val result = mutableListOf<String>()
        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(board, i, j, trie.root, result)
            }
        }
        return result
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, node: TrieNode, result: MutableList<String>) {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size) return
        val c = board[i][j]
        if (c == '#' || node.children[c - 'a'] == null) return
        val next = node.children[c - 'a']!!
        if (next.word != null) {
            result.add(next.word!!)
            next.word = null
        }
        board[i][j] = '#'
        dfs(board, i + 1, j, next, result)
        dfs(board, i - 1, j, next, result)
        dfs(board, i, j + 1, next, result)
        dfs(board, i, j - 1, next, result)
        board[i][j] = c
    }

    class Trie {
        val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (c in word) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = TrieNode()
                }
                node = node.children[c - 'a']!!
            }
            node.word = word
        }
    }

    class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var word: String? = null
    }
}