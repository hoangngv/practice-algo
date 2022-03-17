package codility.training

// Lesson 1: Iterations
// BinaryGap -> Find the longest sequence of zeros in binary representation of an integer.
// Below solution covered 100% test cases
// optional: MinDistinct
fun findBinaryGap(number: Int): Int {
    val binaryString = Integer.toBinaryString(number)
    var gap = 0
    var tempGap = 0
    var beginCounter = false
    binaryString.forEachIndexed { index, char ->
        if (char == '1') {
            if (tempGap > gap) gap = tempGap
            tempGap = 0
            beginCounter = true
        } else {
            if (beginCounter) tempGap++
        }
    }
    return gap
}

fun main() {
    print("Binary gap ->  ${findBinaryGap(number = 32)}")
}