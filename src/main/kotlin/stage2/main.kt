package stage2

fun main() {
    println("Enter the number of people:")
    val noOfPeople = readLine()!!.toInt()

    println("Enter all people:")
    val people = Array(noOfPeople) { readLine()!! }

    println("Enter the number of search queries:")
    val noOfQueries = readLine()!!.toInt()

    repeat (noOfQueries) {
        println("Enter data to search people:")
        val query = readLine()!!

        val matches = people.filter { it.contains(query, ignoreCase = true) }
        if (matches.isEmpty()) {
            println("No matching people found.")
        } else {
            matches.forEach { println(it) }
        }
    }
}