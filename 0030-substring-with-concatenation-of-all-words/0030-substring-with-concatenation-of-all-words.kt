class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = mutableListOf<Int>()
        if (s.isEmpty() || words.isEmpty()) return result

        val wordLength = words[0].length
        val wordCount = words.size
        val wordMap = mutableMapOf<String, Int>()
        words.forEach { wordMap[it] = wordMap.getOrDefault(it, 0) + 1 }

        for (i in 0 until wordLength) {
            var left = i
            var right = i
            var count = 0
            val currentMap = mutableMapOf<String, Int>()

            while (right + wordLength <= s.length) {
                val word = s.substring(right, right + wordLength)
                right += wordLength

                if (wordMap.containsKey(word)) {
                    currentMap[word] = currentMap.getOrDefault(word, 0) + 1
                    count++

                    while (currentMap[word]!! > wordMap[word]!!) {
                        val leftWord = s.substring(left, left + wordLength)
                        left += wordLength
                        currentMap[leftWord] = currentMap[leftWord]!! - 1
                        count--
                    }

                    if (count == wordCount) result.add(left)
                } else {
                    left = right
                    currentMap.clear()
                    count = 0
                }
            }
        }

        return result
    }
}