import java.util.*
import kotlin.Comparator

class EasySolution {

    /* 13. Roman to Integer */
    fun romanToInt(s: String): Int {
        var romanInteger = 0
        var iter = 0
        while (iter < s.length) {
            println("i = $iter")
            val currentNumber = getValueFromSymbol(s[iter])
            if (iter + 1 < s.length) {
                val subsequentNumber = getValueFromSymbol(s[iter + 1])
                if (currentNumber >= subsequentNumber) {
                    romanInteger += currentNumber
                } else {
                    romanInteger = romanInteger + subsequentNumber - currentNumber
                    iter++
                }
            } else {
                romanInteger += currentNumber
            }
            iter++
        }
        return romanInteger
    }

    private fun getValueFromSymbol(char: Char): Int {
        return when (char) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }

    /* 9. Palindrome Number */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x in 0..9) return true
        val numberInString = x.toString()

        /* Solution 1 */
//        val centerCharacterIndex = numberInString.length/2
//        var leftIndex = 0
//        var rightIndex = numberInString.length-1
//
//        while (leftIndex < centerCharacterIndex && rightIndex >= centerCharacterIndex) {
//            if (numberInString[leftIndex] != numberInString[rightIndex]) return false
//            leftIndex++
//            rightIndex--
//        }
//        return true

        /* Solution 2 */
        return numberInString == numberInString.reversed()
    }

    /* 14. Longest Common Prefix */
    fun longestCommonPrefix(strs: Array<String>): String {
        /* Solution 1 */
//        var commonPrefix = ""
//        Arrays.sort(strs, object: Comparator<String> {
//            override fun compare(word1: String, word2: String): Int {
//                return word1.length - word2.length
//            }
//        })
//        for (i in strs[0].indices) {
//            val character = strs[0][i]
//            var stop = false
//            for (j in 1 until strs.size) {
//                if (strs[j][i] != character) stop = true
//            }
//            if (stop) break
//            commonPrefix += character
//        }
//        return commonPrefix

        /* Solution 2 */
        var output = ""
        for (i in 0..200) {
            var previous: Char? = null
            for (s in strs) {
                if (i > s.length - 1 || (previous != null && s[i] != previous)) {
                    // if current index is out of bound or current char != previous (char of previous word)
                    return output
                }
                previous = s[i]
            }
            output += previous
        }
        return output
    }

    /* 20. Valid Parentheses */
    fun isValid(s: String): Boolean {
        val bracketMap = HashMap<Char, Char>()
        bracketMap[')'] = '('
        bracketMap['}'] = '{'
        bracketMap[']'] = '['

        val stack = Stack<Char>()
        s.forEach {
            // closing bracket
            if (bracketMap.containsKey(it)) {
                val topInStack = if (stack.isEmpty()) '#' else stack.peek()
                if (topInStack == bracketMap[it]) stack.pop()
                else return false
            } else {
                // opening bracket
                stack.push(it)
            }
        }

        return stack.isEmpty()
    }
}

fun main(args: Array<String>) {
    val solution = EasySolution()
    // println(solution.romanToInt("MCMXCIV"))
    // println(solution.isPalindrome(100))
    // println(solution.longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(solution.isValid("()[]{}"))
}