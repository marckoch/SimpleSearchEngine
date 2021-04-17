package stage1

fun main() {
    val input = readLine()!!.split(" ")
    val n = readLine()!!
    if (input.indexOf(n) >= 0) {
        println(input.indexOf(n) + 1)
    } else {
        println("Not found")
    }
}