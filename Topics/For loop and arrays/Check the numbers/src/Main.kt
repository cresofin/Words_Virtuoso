fun main() {
    val size = readln().toInt()
    val array = MutableList(size) { 0 }
    for (i in 0..array.lastIndex) {
        array[i] = readln().toInt()
    }
    val numbersToSee = readln().split(" ").map { it.toInt() }.toMutableList()
    for (i in 0..array.lastIndex) {
        if (i + 1 <= array.lastIndex && (array[i] == numbersToSee[0] && array[i + 1] == numbersToSee[1] ||
                    array[i] == numbersToSee[1] && array[i + 1] == numbersToSee[0])) {
            println("NO")
            return
        }
    }
    println("YES")
}
