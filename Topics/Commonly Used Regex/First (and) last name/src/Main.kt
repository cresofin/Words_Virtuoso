fun main() {
    val regex = Regex("""([A-Z][a-z]+)(\s?[A-Z][a-z]+)?""")
    val names = regex.findAll(readln())
    for (name in names) println(name.value)
}
