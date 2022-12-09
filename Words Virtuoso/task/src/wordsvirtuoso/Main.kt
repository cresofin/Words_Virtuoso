package wordsvirtuoso
import java.io.File
import kotlin.random.Random.Default.nextInt

val invalidWords = mutableListOf<String>()
val lettersRepeats = mutableListOf<Char>()

fun main(args :Array<String>) {
    if (args.size != 2) {
        println("Error: Wrong number of arguments.")
        return
    }
    val allWords = File(args[0])
    if (!allWords.exists()){
        println("Error: The words file ${args[0]} doesn't exist.")
        return
    }
    val candidateWords = File(args[1])
    if (!candidateWords.exists()){
        println("Error: The candidate words file ${args[1]} doesn't exist.")
        return
    }
    checkWords(args[0])
    checkWords(args[1])
    val candidateWordsLines = candidateWords.readLines()
    val allWordsLines = allWords.readLines()
    var canWordNotAllWord = 0
    for (line in candidateWordsLines) {
        if (line.lowercase() in allWordsLines || line.uppercase() in allWordsLines) {
            continue
        } else {
           canWordNotAllWord++
        }
    }
    if (canWordNotAllWord != 0) {
        println("Error: $canWordNotAllWord candidate words are not included in the ${args[0]} file.")
        return
    }
    var attempts = 1
    val attemptsWords = mutableListOf<String>()
    println("Words Virtuoso")
    val number = nextInt(0,candidateWordsLines.size)
    val magicWord = candidateWordsLines[number]
    val charNotInMagicWord = mutableListOf<Char>()
    loop@ while (true) {
        println("\nInput a 5-letter word:")
        val start = System.currentTimeMillis()
        val userWord = readln().lowercase()
        if (userWord == "exit") {
            println("The game is over.")
            return
        }
        if (userWord == magicWord) {
            if (attempts == 1) {
                for (i in userWord){
                    print("\u001B[48:5:10m" + i.uppercase() + "\u001B[0m")
                }

                println("\n\nCorrect!")
                println("Amazing luck! The solution was found at once.")
                return
            } else {
                for (i in attemptsWords) {
                    println(i)
                }
                for (i in userWord){
                    print("\u001B[48:5:10m" + i.uppercase() + "\u001B[0m")
                }
                println("\nCorrect!")
                val end = System.currentTimeMillis()
                val time = (end - start) / 1000
                println("The solution was found after $attempts tries in $time seconds.")
                return
            }
        }
        if (userWord.length != 5) {
            println("The input isn't a 5-letter word.")
            continue
        }
        val duplicatesWords = mutableListOf<Char>()
        duplicatesWords.clear()
        for (i in userWord) {
            if (i !in 'a'..'z') {
                println("One or more letters of the input aren't valid.")
                continue@loop
            }
            if (i in duplicatesWords) {
                println("The input has duplicate letters.")
                continue@loop
            } else {
                duplicatesWords.add(i)
            }
        }
        if (userWord !in allWordsLines) {
            println("The input word isn't included in my words list.")
            continue
        }
        var word = ""
        for (i in 0..4) {
            if (userWord[i] in magicWord) {
                if (userWord[i] == magicWord[i]) {
                    word += "\u001B[48:5:10m${userWord[i].uppercase()}\u001B[0m"
                    continue
                }
                word += "\u001B[48:5:11m${userWord[i].uppercase()}\u001B[0m"
                continue
            } else {
                word += "\u001B[48:5:7m${userWord[i].uppercase()}\u001B[0m"
                if (userWord[i].uppercaseChar() in charNotInMagicWord) {
                    continue
                } else {
                    charNotInMagicWord.add(userWord[i].uppercaseChar())
                }
            }
        }
        println("")
        attemptsWords.add(word)
        attempts++
        for (i in attemptsWords) {
            println(i)
        }
        println("\n\u001B[48:5:14m${charNotInMagicWord.sorted().joinToString("")}\u001B[0m")
    }
}

fun checkWords (fileName : String) {
    invalidWords.clear()
    val file = File(fileName)
    val lines = file.readLines()
    for (line in lines) {
        lettersRepeats.clear()
        if (line.length == 5) {
            for (i in line) {
                if (i in lettersRepeats) {
                    invalidWords.add(line)
                    break
                } else {
                    lettersRepeats.add(i)
                }
                if (i in 'a'..'z' || i in 'A'..'Z') {
                    continue
                } else {
                    invalidWords.add(line)
                    break
                }
            }
        } else {
            invalidWords.add(line)
        }
    }
    if (invalidWords.size != 0) {
        println("Error: ${invalidWords.size} invalid words were found in the $file file.")
        return
    }
}
