import java.io.File

val input = File("input8.txt").readLines().map { Op(it.split(" ")[0], it.split(" ")[1].toLong()) }

data class Op(var code: String, val arg: Long)
var acc = 0L

fun run(): Int {
    acc = 0
    var pc = 0
    val duplicates = input.map { 0 }.toIntArray()

    while (true) {
        duplicates[pc]++
        val next = input[pc]
        when (next.code) {
            "nop" -> pc++
            "jmp" -> pc += next.arg
            "acc" -> acc += next.arg.also { pc++ }
        }
        if (duplicates.any { it > 1 }) return -1
        if (pc == input.size) return 0
    }
}

fun sol2() = input.forEach { op ->
    val origOp = op.code
    when (op.code) {
        "jmp" -> op.code = "nop"
        "nop" -> op.code = "jmp"
    }
    when (run()) {
        -1 -> op.code = origOp
        else -> return
    }
}

run().also { println("sol1: $acc") }
sol2().also { println("sol1: $acc") }
