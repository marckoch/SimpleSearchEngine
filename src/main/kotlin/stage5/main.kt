package stage5

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

fun buildInvertedIndex(lines: List<String>): Map<String, List<Int>> {
    val index = mutableMapOf<String, MutableList<Int>>()
    for (line in lines.withIndex()) {
        val parts = line.value.split(" ")
        for (part in parts) {
            val list = index.getOrDefault(part, mutableListOf())
            list.add(line.index)
            index[part] = list
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

fun find(people: List<String>, index: Map<String, List<Int>>) {
    println("Enter a name or email to search all suitable people.")
    val query = readLine()!!

    if (index.containsKey(query)) {
        val listOfMatches = index[query]
        listOfMatches?.forEach { println(people[it]) }
    } else {
        println("No matching people found.")
    }
}

fun print(people: List<String>) {
    println("=== List of people ===")
    people.forEach { println(it) }
}