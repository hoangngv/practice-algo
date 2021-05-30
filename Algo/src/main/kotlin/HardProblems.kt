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
                    println("${sumArray[j+1]}")
                    rangeSumCounter++
                }
            }
        }

        return rangeSumCounter
    }

    fun countRangeSumUsingTreeMap(nums: IntArray, lower: Int, upper: Int): Int {
        if (nums.isEmpty()) return 0

        val treeMap = TreeMap<Long, Int>()
        var rangeSumCounter = 0
        var cumulativeSum: Long = 0
        treeMap[cumulativeSum] = 1

        /* For each cumulative sum[i], we need to find all
        the previous cumulative sum[j]'s such that sum[i]-upper<=sum[j]<=sum[i]-lower.
        TreeMap's subMap method can achieve this. */
        for (number in nums) {
            cumulativeSum += number.toLong()

            val subMap: Map<Long, Int> = treeMap.subMap(cumulativeSum - upper, true, cumulativeSum - lower, true)

            for (value in subMap.values) {
                rangeSumCounter += value
            }

            treeMap[cumulativeSum] = treeMap.getOrDefault(cumulativeSum, 0) + 1
        }

        return rangeSumCounter
    }
}

fun main(args: Array<String>) {
    val solution = HardSolution()
    // println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
    println(solution.countRangeSumUsingTreeMap(intArrayOf(-2, 5, -1), -2, 2))
}