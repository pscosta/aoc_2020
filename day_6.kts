import java.io.File

val groups = File("input6.txt").readText().split("\n\n")

fun day6() {
    val sol1 = groups.map { it.replace("\n", "") }
        .map { it.groupBy { it }.count() }

    val sol2 = groups.map { group ->
        group.replace("\n", "").groupBy { it }
            .filter { it.value.count() == group.split("\n").size }
            .count()
    }

    println("Sol1: ${sol1.sum()}")
    println("Sol2: ${sol2.sum()}")
}