package stage3

fun main() {
    println("Enter the number of people:")
    val noOfPeople = readLine()!!.toInt()

    println("Enter all people:")
    val people = Array(noOfPeople) { readLine()!! }

    do {
        printMenu()
        val choice = readLine()!!.toInt()

        when (choice) {
            0 -> break
            1 -> find(people)
            2 -> print(people)
            else -> println("Incorrect option! Try again.")
        }
    } while (true)

    println("Bye!")
}

fun printMenu() {
    println("=== Menu ===")
    println("1. Find a person")
    println("2. Print all people")
    println("0. Exit")
}

fun find(people: Array<String>) {
    println("Enter a name or email to search all suitable people.")
    val query = readLine()!!

    val matches = people.filter { it.contains(query, ignoreCase = true) }
    if (matches.isEmpty()) {
        println("No matching people found.")
    } else {
        matches.forEach { println(it) }
    }
}

fun print(people: Array<String>) {
    println("=== List of people ===")
    people.forEach { println(it) }
}