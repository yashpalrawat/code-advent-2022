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
        countIfOverlap(firstPair, secondPair)
    }

    print(result)
}


fun countIfOverlap(firstAssignment: Pair<Int, Int>, secondAssignment: Pair<Int, Int>) : Int {

    val result = (secondAssignment.first in firstAssignment.first..firstAssignment.second) ||
            (secondAssignment.second in firstAssignment.first..firstAssignment.second) ||
            (firstAssignment.first in secondAssignment.first..secondAssignment.second) ||
            (firstAssignment.second in secondAssignment.first..secondAssignment.second)

    return if(result) {
        1
    } else {
        0
    }
}