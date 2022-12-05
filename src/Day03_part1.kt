fun main() {

    val input = readInput("Day03")

    // split string into two halves
    // add all elements of first string to a map
    // iterate through second string and see if record existing in first map
    // if exists then add that character to result list ( or just get the priority )

    val priorities = getPriorities()

    val totalPriority = input.sumOf {
        val (str1, str2) = splitString(it)

        val chars = findCommanCharacters(str1, str2)

        val characterPriority = chars.sumOf { priorities[it] ?: 0 }

        println("comman chars: $chars, characterPriority: $characterPriority")

        characterPriority
    }

    println(totalPriority)
}

fun getPriorities(): Map<Char, Int> {
    return ('a'..'z').associateWith { it.code - 'a'.code + 1 }.plus(
        ('A'..'Z').associateWith { it.code - 'A'.code + 27 }
    )
}

fun findCommanCharacters(firstString: String, secondString: String): Set<Char> {
    val mapOfCharsInFirstString = firstString.associateWith { it to 1 }
    return secondString.toCharArray().filter { mapOfCharsInFirstString.containsKey(it) }.toSet()
}

fun splitString(inputString: String): List<String> {
    return listOf(
        inputString.substring(0, inputString.length / 2),
        inputString.substring(inputString.length / 2)
    )
}