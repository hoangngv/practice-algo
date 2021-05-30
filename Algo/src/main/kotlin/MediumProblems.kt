import java.util.*
import kotlin.math.abs
import kotlin.math.min


class MediumSolution {

    /* 179. Largest Number */
    fun largestNumber(nums: IntArray): String {
        var largestNumber = ""

        if (nums.isEmpty()) return "0"
        if (nums.size == 1) return nums[0].toString()

        val numsInString = nums.map {
            it.toString()
        }.toList()

        /* return a negative int if 1st is less than 2nd
        return a positive int if 1st is greater than 2nd */
        Collections.sort(numsInString, object: Comparator<String> {
            override fun compare(a: String?, b: String?): Int {
                if ((a+b) > (b+a)) return -1
                else if ((a+b) < (b+a)) return 1
                return 0
            }
        })

        if (numsInString[0].toInt() == 0) return "0"

        numsInString.forEach {
            largestNumber += it
        }
        return largestNumber
    }

    /* 12. Integer to Roman */
    fun intToRoman(num: Int): String {
        var inputNumber = num
        var roman = ""
        while (inputNumber > 0) {
            when {
                inputNumber - 1000 >= 0 -> {
                    roman += "M"
                    inputNumber -= 1000
                }
                inputNumber - 900 >= 0 -> {
                    roman += "CM"
                    inputNumber -= 900
                }
                inputNumber - 500 >= 0 -> {
                    roman += "D"
                    inputNumber -= 500
                }
                inputNumber - 400 >= 0 -> {
                    roman += "CD"
                    inputNumber -= 400
                }
                inputNumber - 100 >= 0 -> {
                    roman += "C"
                    inputNumber -= 100
                }
                inputNumber - 90 >= 0 -> {
                    roman += "XC"
                    inputNumber -= 90
                }
                inputNumber - 50 >= 0 -> {
                    roman += "L"
                    inputNumber -= 50
                }
                inputNumber - 40 >= 0 -> {
                    roman += "XL"
                    inputNumber -= 40
                }
                inputNumber - 10 >= 0 -> {
                    roman += "X"
                    inputNumber -= 10
                }
                inputNumber - 9 >= 0 -> {
                    roman += "IX"
                    inputNumber -= 9
                }
                inputNumber - 5 >= 0 -> {
                    roman += "V"
                    inputNumber -= 5
                }
                inputNumber - 4 >= 0 -> {
                    roman += "IV"
                    inputNumber -= 4
                }
                inputNumber - 1 >= 0 -> {
                    roman += "I"
                    inputNumber -= 1
                }
            }
        }
        return roman
    }

    /* 1366. Rank Teams by Votes */
    fun rankTeams(votes: Array<String>): String {
        val n: Int = votes.size
        val firstVote = votes[0]

        if (n == 1) return firstVote

        val rank = Array(26) { IntArray(27) }

        // set the first element of each int array as team ID
        firstVote.forEachIndexed { index, char ->
            val idx = char - 'A'
            rank[idx][0] = idx + 1
        }

        for (vote in votes) {
            vote.forEachIndexed { index, char ->
                val idx = char - 'A'
                rank[idx][index+1]++ // from 2nd to n -> each indicates the number of votes for each position
            }
        }

        Collections.sort(rank.asList(), object : Comparator<IntArray> {
            override fun compare(array1: IntArray, array2: IntArray): Int {
                for (i in 1..26) {
                    if (array1[i] != array2[i]) {
                        return array2[i]-array1[i]
                    }
                }
                return array1[0]-array2[0]
            }
        })

        var voteResult = ""
        for (i in 0..25) {
            if (rank[i][0] > 0) {
                // convert team ID back to char
                voteResult += ('A'.toInt() + (rank[i][0]-1)).toChar()
            }
        }

        return voteResult
    }

    /* 1509. Minimum Difference Between Largest and Smallest Value in Three Moves */
    fun minDifference(nums: IntArray): Int {
        val numOfElements: Int = nums.size
        var res = Int.MAX_VALUE
        if (numOfElements < 5) return 0
        Arrays.sort(nums)

        /*
        4 cases:
            kill 3 biggest elements -> res = A[n-4]-A[0]
            kill 2 biggest elements + 1 smallest elements -> res = A[n-3]-A[1]
            kill 1 biggest elements + 2 smallest elements -> res = A[n-2]-A[2]
            kill 3 smallest elements -> res = A[n-1]-A[3]

        -> answer is the smallest one out of 4 above cases
        */

        for (i in 0..3) {
            res = Math.min(res, nums[numOfElements-4+i] - nums[i])
        }

        return res
    }

    /* 1846. Maximum Element After Decreasing and Rearranging */
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()

        if (arr[0] != 1) {
            for (idx in 1 until arr.size) {
                if (arr[idx] == 1) {
                    val temp = arr[0]
                    arr[0] = 1
                    arr[idx] = temp
                    break
                }
            }
            arr[0] = 1
        }

        var max = 1
        for (idx in 1 until arr.size) {
            if (Math.abs(arr[idx]-arr[idx-1]) > 1) {
                arr[idx] = arr[idx-1]+1
            }
            max = Math.max(max, arr[idx])
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = MediumSolution()
    println(solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(75,98,9)))
    // println(solution.minDifference(intArrayOf(1,5,0,10,14)))
    // println(solution.largestNumber(nums = intArrayOf(999999991,9)))
    // println(solution.intToRoman(1994))
    // println(solution.rankTeams(arrayOf("ABC", "ACB","ABC","ACB","ACB")))
}