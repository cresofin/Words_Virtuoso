fun main() {
    val nNumbers = readln().toInt()
    val numbers = MutableList(nNumbers) { readln().toInt() }
    val numToCheck = readln().toInt()
    println(if (numToCheck in numbers)"YES" else "NO")
}