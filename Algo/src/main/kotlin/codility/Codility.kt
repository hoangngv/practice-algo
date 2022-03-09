package codility

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

fun main(args: Array<String>) {
    val codility = Codility()
    print("Operations = ${codility.calculateMinOperation(binaryString = "111")}")
}