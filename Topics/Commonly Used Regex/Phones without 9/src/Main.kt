fun main() {
    val regex = Regex("""\(?[0-8]{3}\)?-?[0-8]{3}-?[0-8]{4}""")
    val phones = regex.findAll(readln())
    for (phone in phones) println(phone.value)
}