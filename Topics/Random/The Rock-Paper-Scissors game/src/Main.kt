import kotlin.random.Random

fun makeDecision(): String {
    val option = when (Random.nextInt(1, 4)) {
        1 -> "Rock"
        2 -> "Paper"
        else -> "Scissors"
    }
    return option
}
