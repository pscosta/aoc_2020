import java.io.File

val input = File("input8.txt").readLines().map { Op(it.split(" ")[0], it.split(" ")[1].toLong()) }

data class Op(var code: String, val arg: Long)
var acc = 0L

fun run(): Int {
    acc = 0L
    var pc = 0L
    val dup = mutableMapOf<Long, Long>()

    while (true) {
        val next = input[pc.toInt()]
        if (dup[pc] != null) dup[pc] = dup[pc]!! + 1 else dup[pc] = 0L

        when (next.code) {
            "nop" -> pc++
            "jmp" -> pc += next.arg
            "acc" -> acc += next.arg.also { pc++ }
        }
        if (dup.values.any { it > 0 }) return -1
        if (pc.toInt() == input.size) return 0
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
