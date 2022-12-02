import java.util.*


private fun getSortedEnergyLevels(input: List<String>) : List<Int> {

    val energyLevels = mutableListOf<Int>()

    val result = mutableListOf<Int>()

    input.forEach {
        if (it.isNotEmpty()) {
            energyLevels.add(it.toInt())
        } else {
            result.add(energyLevels.sum())
            energyLevels.clear()
        }

    }

    return result.sortedDescending()
}
fun main() {
    fun part1(input: List<String>): Int {
        val energyLevels = getSortedEnergyLevels(input)
        return energyLevels[0]
    }

    fun part2(input: List<String>): Int {
        val energyLevels = getSortedEnergyLevels(input)
        return energyLevels[0] + energyLevels[1] + energyLevels[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
