import java.util.*

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
}

fun main(args: Array<String>) {
    val solution = MediumSolution()
    // println(solution.largestNumber(nums = intArrayOf(999999991,9)))
    // println(solution.intToRoman(1994))
}