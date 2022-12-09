fun parsingNickname(emailString: String): String {
    val symbolsForNickname = Regex("_|\\.") // fix this condition
    val nicknameString = emailString.split("@").first() // fix this condition
    val (firstName, lastName ) = nicknameString.split(symbolsForNickname)
    val nickname = "${firstName[0].uppercaseChar()}${firstName.substring(1,firstName.length)} ${lastName[0].uppercaseChar()}${lastName.substring(1,lastName.length)}"
    return nickname
}
