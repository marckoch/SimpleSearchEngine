package stage6

import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2 || args[0] != "--data") {
        println("usage: <script> --data <filename>")
        exitProcess(1)
    }

    val filename = args[1]
    val people = File(filename).readLines()
    val index = buildInvertedIndex(people)

    do {
        printMenu()
        val choice = readLine()!!.toInt()

        when (choice) {
            0 -> break
            1 -> find(people, index)
            2 -> print(people)
            else -> println("Incorrect option! Try again.")
        }
    } while (true)

    println("Bye!")
}

fun buildInvertedIndex(lines: List<String>): Map<String, Set<Int>> {
    val index = mutableMapOf<String, MutableSet<Int>>()
    for (line in lines.withIndex()) {
        val parts = line.value.split(" ")
        for (part in parts) {
            val list = index.getOrDefault(part.toLowerCase(), mutableSetOf())
            list.add(line.index)
            index[part.toLowerCase()] = list
        }
    }
    return index
}

fun printMenu() {
    println("=== Menu ===")
    println("1. Find a person")
    println("2. Print all people")
    println("0. Exit")
}

fun find(people: List<String>, index: Map<String, Set<Int>>) {
    val strategy = getStrategy()

    println("Enter a name or email to search all suitable people.")
    val queryParts = readLine()!!.split(" ")

    val matchesInIndex = when (strategy) {
        "ALL" -> {
            queryParts.map { getFromIndex(index, it) }.reduce { acc, set -> acc.intersect(set).toMutableSet() }
        }
        "ANY" -> {
            queryParts.map { getFromIndex(index, it) }.reduce { acc, set -> acc.union(set).toMutableSet() }
        }
        "NONE" -> {
            var allLines = people.indices.toMutableSet()
            for (query in queryParts) {
                allLines = allLines.minus(getFromIndex(index, query)).toMutableSet()
            }
            allLines
        }
        else -> emptySet()
    }

    if (matchesInIndex.isNotEmpty()) {
        matchesInIndex.forEach { println(people[it]) }
    } else {
        println("No matching people found.")
    }
}

fun getFromIndex(index: Map<String, Set<Int>>, query: String): Set<Int> {
    return index[query.toLowerCase()] ?: emptySet()
}

fun getStrategy(): String {
    while (true) {
        println("Select a matching strategy: ALL, ANY, NONE")

        val strategy = readLine()!!
        if (strategy in listOf("ALL", "ANY", "NONE")) {
            return strategy
        }
    }
}

fun print(people: List<String>) {
    println("=== List of people ===")
    people.forEach { println(it) }
}