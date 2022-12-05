



fun getWinnerMove(currentMove: MOVETYPE) : MOVETYPE {
    return when (currentMove) {
        MOVETYPE.ROCK -> MOVETYPE.PAPER
        MOVETYPE.SCISSOR -> MOVETYPE.ROCK
        MOVETYPE.PAPER -> MOVETYPE.SCISSOR
    }
}

fun getLoserMove(currentMove: MOVETYPE) : MOVETYPE {
    return when (currentMove) {
        MOVETYPE.ROCK -> MOVETYPE.SCISSOR
        MOVETYPE.SCISSOR -> MOVETYPE.PAPER
        MOVETYPE.PAPER -> MOVETYPE.ROCK
    }
}


fun main() {


    fun part2(input: List<String>): Int {

        var totalScore = 0


        input.forEach {

            val tokens = it.split(" ")
            val firstPlayerMove = mapping[tokens[0]]!!


            totalScore += when(tokens[1]) {
                "X" -> {
                    // lose
                    getLoserMove(firstPlayerMove).value
                }

                "Y" -> {
                    // draw
                    3 + firstPlayerMove.value
                }

                "Z" -> {
                    // win
                    6 + getWinnerMove(firstPlayerMove).value
                }

                else -> throw IllegalArgumentException("invalid value")
            }

        }

        return totalScore

    }

    val input = readInput("Day02")
    println(part2(input))
}