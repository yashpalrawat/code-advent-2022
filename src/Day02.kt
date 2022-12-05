enum class MOVETYPE(val value: Int) {
    ROCK(1),
    PAPER(2),
    SCISSOR(3)
}

val mapping = mapOf(
    "X" to MOVETYPE.ROCK,
    "Y" to MOVETYPE.PAPER,
    "Z" to MOVETYPE.SCISSOR,
    "A" to MOVETYPE.ROCK,
    "B" to MOVETYPE.PAPER,
    "C" to MOVETYPE.SCISSOR,
)

fun findWinningPlayer(firstMove: MOVETYPE, secondMove: MOVETYPE): Int {

    if (firstMove == secondMove) return 0

    when(firstMove) {
        MOVETYPE.ROCK -> {
            return if (secondMove == MOVETYPE.PAPER) {
                2
            } else {
                1
            }
        }
        MOVETYPE.PAPER -> {
            return if (secondMove == MOVETYPE.ROCK) {
                1
            } else {
                2
            }
        }
        MOVETYPE.SCISSOR -> {
            return if (secondMove == MOVETYPE.PAPER) {
                1
            } else {
                2
            }
        }
    }
}


fun main() {


    fun part1(input: List<String>): Int {

        var totalScore = 0


        input.forEach {

            val tokens = it.split(" ")
            val firstPlayerMove = mapping[tokens[0]]!!
            val secondPlayerMove = mapping[tokens[1]]!!


            when(findWinningPlayer(firstPlayerMove, secondPlayerMove)) {
                1 -> {
                    totalScore += secondPlayerMove.value
                }
                2 -> {
                    totalScore += 6 + secondPlayerMove.value
                }
                0 -> {
                    totalScore += 3 + secondPlayerMove.value
                }
            }

        }

        return totalScore

    }

    val input = readInput("Day02")
    println(part1(input))
}