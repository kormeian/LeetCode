class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < words.size) {
            var j = i + 1
            var sum = words[i].length
            while (j < words.size && sum + words[j].length + j - i <= maxWidth) {
                sum += words[j].length
                j++
            }
            val diff = j - i - 1
            val sb = StringBuilder()
            if (j == words.size || diff == 0) {
                for (k in i until j) {
                    sb.append(words[k]).append(" ")
                }
                sb.deleteCharAt(sb.length - 1)
                for (k in sb.length until maxWidth) {
                    sb.append(" ")
                }
            } else {
                val space = (maxWidth - sum) / diff
                val r = (maxWidth - sum) % diff
                for (k in i until j - 1) {
                    sb.append(words[k])
                    for (l in 0 until space + if (k - i < r) 1 else 0) {
                        sb.append(" ")
                    }
                }
                sb.append(words[j - 1])
            }
            result.add(sb.toString())
            i = j
        }
        return result
    }
}