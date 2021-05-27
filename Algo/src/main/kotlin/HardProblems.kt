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

    fun countRangeSum2(nums: IntArray, lower: Int, upper: Int): Int {
        val map = TreeMap<Long, Int>()
        var sum: Long = 0
        var count = 0

        for (element in nums) {
            sum += element
            if (sum in lower..upper) count++
            count += map.subMap(sum - upper, true, sum - lower, true).values.stream()
                .mapToInt { i: Int? ->
                    Integer.valueOf(
                        i!!
                    )
                }
                .sum()
            map[sum] = map.getOrDefault(sum, 0) + 1
        }

        return count

//        if (nums.isEmpty()) {
//            return 0
//        }
//
//        val tree = TreeMap<Long, Int>()
//        tree[0L] = 1
//
//        var count = 0
//        var curSum = 0L
//        for (num in nums) {
//            curSum += num.toLong()
//            for (cnt in tree.subMap(curSum - upper, true, curSum - lower, true).values) {
//                count += cnt
//            }
//            tree[curSum] = tree.getOrDefault(curSum, 0) + 1
//        }
//
//        return count
    }
}

fun main(args: Array<String>) {
    val solution = HardSolution()
    // println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
    println(solution.countRangeSum2(intArrayOf(-2, 5, -1), -2, 2))
}