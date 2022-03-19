package codility.training

import kotlin.math.abs

// Lesson 3: Time Complexity

// FrogJmp - 100%
// URL: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
private fun countMinimalJumps(startPosition: Int, targetPosition: Int, fixedDistance: Int): Int {
    if (startPosition == targetPosition) return 0
    val totalDistance = targetPosition - startPosition
    return if (totalDistance%fixedDistance == 0) totalDistance/fixedDistance else (totalDistance/fixedDistance)+1
}

// PermMissingElem - 100%
// URL: https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
private fun findMissingElement(array: IntArray): Int {
    if (array.isEmpty()) return 1
    val arraySize = array.size
    if (arraySize == 1) {
        if (array[0] == 1) return 2
        return 1
    }
    array.sort()
    if (array[0] != 1) return 1
    if (array[arraySize-1] != arraySize+1) return arraySize+1
    for (idx in array.indices) {
        if (array[idx] != idx+1) return idx+1
    }
    return 1
}

// TapeEquilibriumn - 76%
// URL: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
private fun findMinDifference(array: IntArray): Int {
    val arraySize = array.size
    if (arraySize == 1) return abs(array[0])
    if (arraySize == 2) return abs(array[0]-array[1])
    var totalSum = 0
    for (number in array) {
        totalSum += number
    }
    var minDifferenceFound = abs(totalSum-array[0])
    var cumulativeSum = array[0]
    for (idx in 1..arraySize-2) {
        cumulativeSum += array[idx]
        val difference = abs(cumulativeSum - (totalSum - cumulativeSum))
        if (difference < minDifferenceFound) minDifferenceFound = difference
    }
    return minDifferenceFound
}

fun main() {
//    println(countMinimalJumps(startPosition = 10, targetPosition = 85, fixedDistance = 30))
//    println(findMissingElement(array = intArrayOf(2)))
    println(findMinDifference(intArrayOf(1, 3)))
}