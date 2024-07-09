class Solution {
    fun calculate(s: String): Int {
        val stack = mutableListOf<Int>()
        var result = 0
        var number = 0
        var sign = 1
        for (c in s) {
            when {
                c.isDigit() -> number = number * 10 + (c - '0')
                c == '+' -> {
                    result += sign * number
                    number = 0
                    sign = 1
                }
                c == '-' -> {
                    result += sign * number
                    number = 0
                    sign = -1
                }
                c == '(' -> {
                    stack.add(result)
                    stack.add(sign)
                    result = 0
                    sign = 1
                }
                c == ')' -> {
                    result += sign * number
                    number = 0
                    result *= stack.removeLast()
                    result += stack.removeLast()
                }
            }
        }
        return result + sign * number
    }
}