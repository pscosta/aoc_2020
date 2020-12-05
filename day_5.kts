import java.io.File
import kotlin.math.pow

val passports =
    File("/Users/pco38/Library/Application Support/JetBrains/IntelliJIdea2020.3/scratches/2020/in/input5.txt").readLines()

fun main() {
    val sIDs = passports
        .map { it.reversed() }
        .map { row ->
            row.indices
                .filter { row[it] == 'R' || row[it] == 'B' }
                .sumBy { (2.0.pow(it)).toInt() }
        }
        .sorted()

    println("Sol1: ${sIDs.max()}")

    for (i in 1 until sIDs.size)
        if (sIDs[i] != (sIDs[(i - 1)] + 1))
            println("Sol2: ${sIDs[i] - 1}")
}

main()