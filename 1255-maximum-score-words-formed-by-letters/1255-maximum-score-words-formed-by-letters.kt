class Solution {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val letterCount = IntArray(26)
        for (char in letters) {
            letterCount[char - 'a']++
        }

        fun calculateWordScore(word: String): Int {
            var wordScore = 0
            for (char in word) {
                wordScore += score[char - 'a']
            }
            return wordScore
        }

        fun canFormWord(word: String, letterCount: IntArray): Boolean {
            val tempCount = letterCount.clone()
            for (char in word) {
                if (--tempCount[char - 'a'] < 0) return false
            }
            return true
        }

        fun backtrack(index: Int, currentScore: Int, currentCount: IntArray): Int {
            if (index == words.size) return currentScore
            var maxScore = currentScore
            if (canFormWord(words[index], currentCount)) {
                val tempCount = currentCount.clone()
                for (char in words[index]) {
                    tempCount[char - 'a']--
                }
                maxScore =
                    maxOf(maxScore, backtrack(index + 1, currentScore + calculateWordScore(words[index]), tempCount))
            }
            maxScore = maxOf(maxScore, backtrack(index + 1, currentScore, currentCount))
            return maxScore
        }

        return backtrack(0, 0, letterCount)
    }
}