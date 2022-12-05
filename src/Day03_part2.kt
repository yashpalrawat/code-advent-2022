fun main() {
    val input = readInput("Day03")

    val priorities = getPriorities()

    val result = (input.indices step 3).sumOf {
        val firstElevRuksPack = input[it]
        val secondElevRuksPack = input[it + 1]
        val thirdElevRuksPack = input[it + 2]

        priorities[findCommanCharacter(firstElevRuksPack, secondElevRuksPack, thirdElevRuksPack)] ?: 0
    }

    print(result)
}

private fun findCommanCharacter(
    firstElevRuksPack: String,
    secondElevRuksPack: String,
    thirdElevRuksPack: String): Char {

    val mapOfCharsInFirstString = firstElevRuksPack.associateWith { it to 1 }

    val mapOfCharsInThirdString = thirdElevRuksPack.associateWith { it to 1 }

    val commanChars = secondElevRuksPack
        .toCharArray()
        .filter { mapOfCharsInFirstString.containsKey(it) }.toSet()

    return commanChars.first { mapOfCharsInThirdString.containsKey(it) }
}
