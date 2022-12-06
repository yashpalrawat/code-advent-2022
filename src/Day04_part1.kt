fun main() {
    val input = readInput("Day04")

    /* basically check if one pair is included within other pair

        Pair(a,b) Pair(c,d)

        the are inclusive if

        c >= a && d <= b

        a >= c && b <= d
    * */

    val result = input.sumOf {
        val firstPair = it.split(",")[0].toIntPair()
        val secondPair = it.split(",")[1].toIntPair()
        isInclusive(firstPair, secondPair)
    }

    print(result)
}


fun String.toIntPair() : Pair<Int, Int> {
    val tokens = this.split("-")
    return Pair(tokens[0].toInt(), tokens[1].toInt())
}


fun isInclusive(firstAssignment: Pair<Int, Int>, secondAssignment: Pair<Int, Int>) : Int {

    val result = (firstAssignment.first >= secondAssignment.first &&
            firstAssignment.second <= secondAssignment.second) ||
            (secondAssignment.first >= firstAssignment.first &&
                    secondAssignment.second <= firstAssignment.second)

    return if(result) {
        1
    } else {
        0
    }
}