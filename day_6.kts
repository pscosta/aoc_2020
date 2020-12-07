import java.io.File

val groups = File("input6.txt").readText().split("\n\n")

fun day6() {
    groups.map { it.replace("\n", "") }
        .sumBy { it.groupBy { it }.size }
        .also { println("Sol1: $it") }

    groups.sumBy { g -> g.groupBy { it }
        .filter { it.value.size == g.split("\n").size }.size }
        .also { println("Sol2: $it") }
}
