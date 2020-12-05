import java.io.File

data class Pwd(val min: Int, val max: Int, val char: Char, val pwd: String)

fun main(args: List<String>) {
    val rows = args.map {
        val r = it.split(":")
        val min = r[0].split(" ")[0].split("-")[0]
        val max = r[0].split(" ")[0].split("-")[1]
        val char = r[0].split(" ")[1][0]
        Pwd(min.toInt(), max.toInt(), char, r[1].trim())
    }

    val s1 = rows.count { r -> r.pwd.count { it == r.char } in r.min..r.max }
    println("Sol 1: $s1")

    val s2 = rows.count { r -> (r.pwd[r.min - 1] == r.char) xor (r.pwd[r.max - 1] == r.char) }
    println("Sol 2: $s2")
}

main(File("/Users/pco38/Library/Application Support/JetBrains/IntelliJIdea2020.2/scratches/2020/in/input2.txt").readLines())
