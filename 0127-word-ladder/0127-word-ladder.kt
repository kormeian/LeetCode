class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toMutableSet()
        if (endWord !in wordSet) return 0
        val queue = ArrayDeque<String>()
        queue.add(beginWord)
        var level = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val currentWord = queue.removeFirst()
                if (currentWord == endWord) return level
                for (i in currentWord.indices) {
                    for (c in 'a'..'z') {
                        val newWord = currentWord.substring(0, i) + c + currentWord.substring(i + 1)
                        if (newWord in wordSet) {
                            wordSet.remove(newWord)
                            queue.add(newWord)
                        }
                    }
                }
            }
            level++
        }
        return 0
    }
}