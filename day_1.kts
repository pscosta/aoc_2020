import java.io.File

fun day1() {
    val input = File("input1.txt").readLines().map { it.toInt() }

    sol1@ for (a in input)
        for (b in input)
            if (a + b == 2020) {
                println("Solution 1: ${a * b} - $a, $b")
                break@sol1
            }

    sol2@ for (a in input)
        for (b in input)
            for (c in input)
                if (a + b + c == 2020) {
                    println("Solution 2: ${a * b * c} - $a, $b, $c")
                    break@sol2
                }
}