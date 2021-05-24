import java.util.*

class HardSolution {
    /* 327. Count of Range Sum */
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        var rangeSumCounter = 0
        val numsInLong = Arrays.stream(nums).asLongStream().toArray()
        val sumArray = arrayListOf<Long>()
        var sum = 0L
        sumArray.add(sum)

        numsInLong.forEach {
            sum += it
            sumArray.add(sum)
        }

        for (i in 0..numsInLong.size-1) {
            for (j in i..numsInLong.size-1) {
                if (sumArray[j+1] >= sumArray[i]-upper && sumArray[j+1] <= sumArray[i] - lower) {
                    rangeSumCounter++
                }
            }
        }

        return rangeSumCounter
    }
}

fun main(args: Array<String>) {
    val solution = HardSolution()
    // println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
    println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
}