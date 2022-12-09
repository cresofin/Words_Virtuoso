fun solution(newSet: MutableSet<String>, oldSet: Set<String>): MutableSet<String> {
    for (i in oldSet) {
        if (i.first() == 'a' || i.first() == 'A') {
            newSet.add(i)
        } else {
            continue
        }
    }
    return newSet
}
