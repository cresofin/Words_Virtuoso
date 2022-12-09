fun main() {
    val text = readln()
    val regex = Regex("""([a-z]+)?pa([a-z]+)?""")
    val result = regex.findAll(text)
    for (pa in result) println(pa.value)
}