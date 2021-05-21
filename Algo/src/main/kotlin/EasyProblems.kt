class EasySolution {

    /* 13. Roman to Integer */
    fun romanToInt(s: String): Int {
        var romanInteger = 0
        var iter = 0
        while (iter < s.length) {
            println("i = $iter")
            val currentNumber = getValueFromSymbol(s[iter])
            if (iter+1 < s.length) {
                val subsequentNumber = getValueFromSymbol(s[iter+1])
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
}

fun main(args: Array<String>) {
    val solution = EasySolution()
    // println(solution.romanToInt("MCMXCIV"))
    println(solution.isPalindrome(100))
}