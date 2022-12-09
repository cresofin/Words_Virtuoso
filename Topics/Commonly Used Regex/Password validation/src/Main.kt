fun main() {
    val regex = Regex("""[A-Z]+[a-z]+\d+""")
    val matchResult = readln()
    println(if(matchResult.matches(regex))"Password saved" else "Password is too simple")
}