fun main() {
    val number = readln()
    // write your code here
    println(number.replace("[a-z|A-Z]".toRegex(), ""))
}
