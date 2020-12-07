import java.io.File

val input = File("input7.txt").readLines()

val ruleRegex = Regex("(.*) bags contain(.*)")
val bagsRegex = Regex("([0-9]+) (.*?) bags?")
data class Bag(val size: Int, val color: String)

val bags = input
    .map { ruleRegex.find(it)!!.destructured }
    .map { (bag, children) -> bag to
         bagsRegex.findAll(children)
            .map { it.destructured }
            .map { (size, color) -> Bag(size.toInt(), color) }
    }.toMap()

fun search(bag: String): List<String> = bags
    .filter { it.value.any { it.color == bag } }
    .flatMap { search(it.key) }.distinct()
    .plus(bag)

fun count(color: String): Int = when {
    !bags.containsKey(color) -> 0
    else -> bags[color]!!.sumBy { count(it.color) * it.size }.inc()
}

println(search("shiny gold").size.dec())
println(count("shiny gold").dec())
