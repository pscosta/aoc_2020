import java.io.File
import java.util.regex.Pattern.compile

val passports = File("input4.txt").readText()
        .split("\n\n") // passport delimiter
        .map { it.replace("\n", " ") } // all passport fields in one line

data class Field(val name: String, val value: String)
fun String.fields() = this.split(" ").map { Field(it.split(":")[0], it.split(":")[1]) }

val required = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
val regexes = mapOf(
    "byr" to compile("19[2-8][0-9]|199[0-9]|200[0-2]"),
    "iyr" to compile("201[0-9]|2020"),
    "eyr" to compile("202[0-9]|2030"),
    "hgt" to compile("(1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in"),
    "hcl" to compile("#[0-9a-f]{6}"),
    "ecl" to compile("amb|blu|brn|gry|grn|hzl|oth"),
    "pid" to compile("[0-9]{9}")
)

fun day4() {
    val sol1 = passports.filter { it.fields().map { it.name }.containsAll(required) }

    val sol2 = passports
        .filter { it.fields().map { it.name }.containsAll(required) }
        .filter {
            it.fields()
                .filterNot { it.name == "cid" }
                .all { regexes[it.name]!!.matcher(it.value).matches() }
        }

    println("Sol1: ${sol1.count()}")
    println("Sol2: ${sol2.count()}")
}