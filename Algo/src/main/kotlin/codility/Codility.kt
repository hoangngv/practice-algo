package codility

import java.io.IOException
import java.io.Reader

class Codility {
    // Task 1: run length encoding
    fun calculateMinOperation(binaryString: String): Int {
        val decimalNumber = Integer.parseInt(binaryString, 2)
        return divide(number = decimalNumber, operations = 0)
    }

    private fun divide(number: Int, operations: Int): Int {
        if (number == 0) return operations
        if (number % 2 == 0) {
            return divide(number/2, operations+1)
        }
        return divide(number-1, operations+1)
    }
}

class SolutionIter(private val reader: Reader): Iterable<Int> {
    override fun iterator(): Iterator<Int> {
        val list = arrayListOf<Int>()
        var charCode: Int
        var line = StringBuilder("")
        var s: String
        var number: Int?
        try {
            while (true) {
                charCode = reader.read()
                if (charCode == 10 || charCode == -1) {
                    s = line.toString().trim()
                    number = s.toIntOrNull()
                    if (number != null && number <= 1000000000 && number >= -1000000000) list.add(number)
                    line = StringBuilder("")
                    if (charCode == -1) break
                } else {
                    line.append(charCode)
                }
            }
            reader.close()
        } catch (e: IOException) {

        }
        return list.iterator()
    }
}

fun main(args: Array<String>) {
    val codility = Codility()
    print("Operations = ${codility.calculateMinOperation(binaryString = "111")}")
}