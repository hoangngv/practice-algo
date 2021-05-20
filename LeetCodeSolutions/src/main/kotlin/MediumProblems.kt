import java.util.*
import kotlin.Comparator

class Solution {
    fun largestNumber(nums: IntArray): String {
        var largestNumber = ""

        if (nums.size < 1) return "0"
        if (nums.size == 1) return nums[0].toString()

        val numsInString = nums.map {
            it.toString()
        }.toList()

//        return a negative int if 1st is less than 2nd
//        return a positive int if 1st is greater than 2nd
        Collections.sort(numsInString, object: Comparator<String> {
            override fun compare(a: String?, b: String?): Int {
                if ((a+b).toInt() > (b+a).toInt()) return -1
                else if ((a+b).toInt() < (b+a).toInt()) return 1
                return 0
            }
        })

        if (numsInString[0].toInt() == 0) return "0"

        numsInString.forEach {
            largestNumber += it
        }
        return largestNumber
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.largestNumber(nums = intArrayOf(999999991,9)))
}