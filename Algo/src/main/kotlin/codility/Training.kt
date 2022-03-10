package codility

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

// Lesson 2: Arrays
// CyclicRotation - 100%
fun rotateIntArray(array: IntArray, times: Int): IntArray {
    val arraySize = array.size
    if (array.isEmpty() || arraySize == 1 || arraySize == times || times == 0) return array
    val lastIndex = arraySize-1
    val shiftedArray = IntArray(array.size)
    val actualTimes = times%arraySize
    for (idx in array.indices) {
        val indexAfterShifted = idx+actualTimes
        val newIndex = if (indexAfterShifted > lastIndex) indexAfterShifted - arraySize else indexAfterShifted
        shiftedArray[newIndex] = array[idx]
    }
    return shiftedArray
}

// OddOccurrencesInArray - 100%
fun findUnpairedElement(array: IntArray): Int {
    val arraySize = array.size
    if (arraySize == 1) return array[0]
    array.sort() // sort in-place
    if (array[arraySize-1] != array[arraySize-2]) return array[arraySize-1]
    var checkPair = true
    var previousNumber = array[0]
    for (idx in 1 until array.size) {
        if (checkPair) {
            if (previousNumber == array[idx]) checkPair = false
            else return previousNumber
        } else {
            previousNumber = array[idx]
            checkPair = true
        }
    }
    return array[arraySize-1]
}

fun main() {
//    print("Binary gap ->  ${findBinaryGap(number = 32)}") // Binary Gap
//    val shiftedArray = rotateIntArray(array = intArrayOf(3, 8, 9, 7, 6), times = 3)
//    for (number in shiftedArray) {
//        println(number)
//    }
    print("Unpaired element = ${findUnpairedElement(array = intArrayOf(9, 9, 3))}")
}