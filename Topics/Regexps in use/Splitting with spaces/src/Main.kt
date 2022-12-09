fun main() {
    val string = readLine()!!
    val n = readLine()!!.toInt()
    val strings = string.split(" +".toRegex(), limit = n)
    for (i in strings) {
        println(i)
    }
}