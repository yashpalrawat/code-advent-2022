fun main() {
    val inputCommands = readInput("Day05")

    val crates = listOf(
        mutableListOf(),
        mutableListOf("F", "L", "M", "W"),
        mutableListOf("F", "M", "V", "Z", "B"),
        mutableListOf("Q", "L", "S", "R", "V", "H"),
        mutableListOf("J", "T", "M", "P", "Q", "V", "S", "F"),
        mutableListOf("W", "S", "L"),
        mutableListOf("W", "J", "R", "M", "P", "V", "F"),
        mutableListOf("F", "R", "N", "P", "C", "Q", "J"),
        mutableListOf("B", "R", "W", "Z", "S", "P", "H", "V"),
        mutableListOf("W", "Z", "H", "G", "C", "J", "M", "B"),
    )

//    val crates = listOf(
//        mutableListOf(),
//        mutableListOf("N", "Z"),
//        mutableListOf("D", "C", "M"),
//        mutableListOf("P"),
//    )

    inputCommands.forEach {
        val match = Regex("move (\\d+) from (\\d+) to (\\d+)").find(it)
        val (quantity, from, to) = match!!.destructured

        updateCrates9001(crates, from.toInt(), to.toInt(), quantity.toInt())
//        println(crates)
    }

    val result = crates.subList(1, crates.size).joinToString("") { it[0] }
    println(result)
}


fun updateCrates9001(crates: List<MutableList<String>>, from: Int, to: Int, quantity: Int) {
    val cratesToBeMoved = crates[from].subList(0, quantity)

    crates[to].addAll(0, cratesToBeMoved)

    (0 until quantity).forEach { _ ->
        crates[from].removeAt(0)
    }
}