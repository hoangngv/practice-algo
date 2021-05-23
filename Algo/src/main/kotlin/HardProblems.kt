class HardSolution {
    /* 327. Count of Range Sum */
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val rangSumCounter = 0
        println(countSubArray(nums, lower, upper))
        return rangSumCounter
    }

    private fun countSubArray(array: IntArray, lowerLimit: Int, upperLimit: Int): Int {
        var counter = 0
        for (i in 0..array.size-1) {
            var sum = 0
            for (j in i..array.size-1) {
                if (sum + array[j] >= lowerLimit && sum + array[j] <= upperLimit) {
                    sum += array[j]
                    counter++
                } else {
                    println(sum)
                    break
                }
            }
        }
        return counter
    }
}

fun main(args: Array<String>) {
    val solution = HardSolution()
    println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
}