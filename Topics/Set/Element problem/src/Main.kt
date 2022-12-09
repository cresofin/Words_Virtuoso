fun solution(first: Set<String>, second: MutableList<String>): Boolean {
    return second.toSet().containsAll(first)
}
