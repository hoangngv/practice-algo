package codility.training

// Lesson 4 - Counting Elements

// FrogRiverOne - 100%
// URL: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

private fun solution(target: Int, array: IntArray): Int {
    val positionLeavesCovered = mutableSetOf<Int>()
    for (idx in array.indices) {
        val position = array[idx]
        if (position <= target) {
            positionLeavesCovered.add(position)
        }
        if (positionLeavesCovered.size == target) return idx
    }
    return -1
}

fun main() {
    println(solution(target = 5, intArrayOf(1, 3, 1, 4, 2, 3, 5, 4)))
}