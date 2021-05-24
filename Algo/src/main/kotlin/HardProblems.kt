import java.util.*

class HardSolution {
    /* 327. Count of Range Sum */
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        var rangeSumCounter = 0
        val numsInLong = Arrays.stream(nums).asLongStream().toArray()
        val sumArray = arrayListOf<Long>()
        for (i in 0..numsInLong.size-1) {
            var sum = 0L
            for (j in i..numsInLong.size-1) {
                sum += nums[j]
                sumArray.add(sum)
            }
        }
        for (sum in sumArray) {
            if (sum in lower..upper){
                rangeSumCounter++
            }
        }
        return rangeSumCounter
    }
}

fun main(args: Array<String>) {
    val solution = HardSolution()
    // println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
    println(solution.countRangeSum(intArrayOf(0), 0, 0))
}