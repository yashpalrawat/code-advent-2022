fun main() {
    val input = readInput("Day06")

    val result = input.map {str ->
        str to findAnswer(str, 4)
    }

    println(result)
}

/*
Algo: 1

numberOfCharactersAlreadyRead = 0


iterate over characters indices from 0 to input.length - 4
pick first 4 characters and
    see if there are duplicates
        numberOfCharactersAlreadyRead += 1
        go to next character


    if there are no duplicates
        numberOfCharactersAlreadyRead + 4
 */
fun findAnswer(str: String, numberOfCharactersInSequence: Int) : Int {
    var numberOfCharactersAlreadyRead = 0

    (0..str.length - numberOfCharactersInSequence).forEach {

        val count = str.substring(it, it + numberOfCharactersInSequence).toSet().size

        // All unique characters
        if (count == 14) {
            return numberOfCharactersAlreadyRead + numberOfCharactersInSequence
        } else {

            numberOfCharactersAlreadyRead += 1

        }

    }

    return -1
}