fun main() {
    val input = readInput("Day06")

    val result = input.map {str ->
        str to findAnswer(str, 14)
    }

    println(result)
}