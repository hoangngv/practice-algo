import java.util.*


class EasySolution {

    /* 13. Roman to Integer */
    fun romanToInt(s: String): Int {
        var romanInteger = 0
        var iter = 0
        while (iter < s.length) {
            println("i = $iter")
            val currentNumber = getValueFromSymbol(s[iter])
            if (iter + 1 < s.length) {
                val subsequentNumber = getValueFromSymbol(s[iter + 1])
                if (currentNumber >= subsequentNumber) {
                    romanInteger += currentNumber
                } else {
                    romanInteger = romanInteger + subsequentNumber - currentNumber
                    iter++
                }
            } else {
                romanInteger += currentNumber
            }
            iter++
        }
        return romanInteger
    }

    private fun getValueFromSymbol(char: Char): Int {
        return when (char) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }

    /* 9. Palindrome Number */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x in 0..9) return true
        val numberInString = x.toString()

        /* Solution 1 */
//        val centerCharacterIndex = numberInString.length/2
//        var leftIndex = 0
//        var rightIndex = numberInString.length-1
//
//        while (leftIndex < centerCharacterIndex && rightIndex >= centerCharacterIndex) {
//            if (numberInString[leftIndex] != numberInString[rightIndex]) return false
//            leftIndex++
//            rightIndex--
//        }
//        return true

        /* Solution 2 */
        return numberInString == numberInString.reversed()
    }

    /* 14. Longest Common Prefix */
    fun longestCommonPrefix(strs: Array<String>): String {
        /* Solution 1 */
//        var commonPrefix = ""
//        Arrays.sort(strs, object: Comparator<String> {
//            override fun compare(word1: String, word2: String): Int {
//                return word1.length - word2.length
//            }
//        })
//        for (i in strs[0].indices) {
//            val character = strs[0][i]
//            var stop = false
//            for (j in 1 until strs.size) {
//                if (strs[j][i] != character) stop = true
//            }
//            if (stop) break
//            commonPrefix += character
//        }
//        return commonPrefix

        /* Solution 2 */
        var output = ""
        for (i in 0..200) {
            var previous: Char? = null
            for (s in strs) {
                if (i > s.length - 1 || (previous != null && s[i] != previous)) {
                    // if current index is out of bound or current char != previous (char of previous word)
                    return output
                }
                previous = s[i]
            }
            output += previous
        }
        return output
    }

    /* 20. Valid Parentheses */
    fun isValid(s: String): Boolean {
        val bracketMap = HashMap<Char, Char>()
        bracketMap[')'] = '('
        bracketMap['}'] = '{'
        bracketMap[']'] = '['

        val stack = Stack<Char>()
        s.forEach {
            // closing bracket
            if (bracketMap.containsKey(it)) {
                val topInStack = if (stack.isEmpty()) '#' else stack.peek()
                if (topInStack == bracketMap[it]) stack.pop()
                else return false
            } else {
                // opening bracket
                stack.push(it)
            }
        }

        return stack.isEmpty()
    }

    /* 27. Remove Element */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var length: Int = nums.size
        while (i < length) {
            if (nums[i] == `val`) {
                // swap current element with the last one and remove it
                nums[i] = nums[length-1]
                length--
            } else {
                i++
            }
        }
        return length
    }

    /*28. Implement strStr()*/
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length) return -1
        if (needle.isEmpty() || haystack.isEmpty()) return 0
        if (haystack.length == needle.length) {
            if (haystack == needle) return 0
            return -1
        } else {
            for (i in 0..haystack.length-needle.length) {
                val substring = haystack.substring(i, i+needle.length)
                if (substring == needle) return i
            }
        }
        return -1
    }

    /*35. Search Insert Position*/
    /*Time complexity O(n)*/
    fun searchInsert(nums: IntArray, target: Int): Int {
        for (index in nums.indices) {
            if (nums[index] == target) {
                return index
            }
            if (nums[index] > target) {
                return index
            }
        }
        return nums.size
    }

    /* Time complexity O(logn) using Binary Search (Iterative implementation, not recursive) */
    fun searchInsert2(nums: IntArray, target: Int): Int {
        var leftIndex = 0
        var rightIndex = nums.size-1

        if (nums[0] > target) return 0
        if (nums[nums.size-1] < target) return nums.size

        while (leftIndex <= rightIndex) {
            val midIndex = leftIndex + (rightIndex-leftIndex)/2 // avoid overflow
            when {
                nums[midIndex] == target -> return midIndex
                nums[midIndex] < target -> leftIndex = midIndex+1
                else -> rightIndex = midIndex-1
            }
            println("$leftIndex $rightIndex")
        }
        return leftIndex
    }

    /* 21. Merge Two Sorted Lists */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val mergedList = ListNode(0)
        var current = mergedList
        var list1 = l1
        var list2 = l2

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2
                break
            }
            if (list2 == null) {
                current.next = list1
                break
            }

            if (list1.`val` < list2.`val`) {
                current.next = list1
                list1 = list1.next
            } else {
                current.next = list2
                list2 = list2.next
            }

            current = current.next!!
        }

        return mergedList.next
    }

    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /* 26. Remove Duplicates from Sorted Array */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 0 // new array index
        for (j in 1 until nums.size) {
            if (nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i+1
    }
}

fun main(args: Array<String>) {
    val solution = EasySolution()
    println(solution.removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
    // println(solution.romanToInt("MCMXCIV"))
    // println(solution.isPalindrome(100))
    // println(solution.longestCommonPrefix(arrayOf("flower","flow","flight")))
    // println(solution.isValid("()[]{}"))
    // println(solution.removeElement(intArrayOf(3,2,2,3), 3))
    // println(solution.strStr("hello", "llo"))
    // println(solution.searchInsert2(intArrayOf(1,3,5,6,8,9,10), 2))
}