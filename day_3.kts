import java.io.File

val path = File("/Users/pco38/Library/Application Support/JetBrains/IntelliJIdea2020.3/scratches/2020/in/input3.txt")
    .readLines()

fun main() {
    println("Sol1: ${run(3, 1)}")
    println("Sol2: ${run(1, 1) * run(3, 1) * run(5, 1) * run(7, 1) * run(1, 2)}")
}

fun run(xSlope: Int, ySlope: Int): Long {
    var y = ySlope
    var x = xSlope
    var tres = 0L
    while (true) {
        if (y >= path.size) break
        if (x >= path[y].length) x -= path[y].length
        if (path[y][x] == '#') ++tres
        y += ySlope
        x += xSlope
    }
    return tres
}

main()