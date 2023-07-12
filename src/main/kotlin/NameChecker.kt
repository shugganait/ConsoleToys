import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val names = mutableListOf<String>()
    for (i in 0 until 10) {
        println("Введите имя ${i + 1}: ")
        val name = scanner.nextLine()
        names.add(name)
    }

    println("Введите ваше имя: ")
    val userName = scanner.nextLine()

    if (checkName(names, userName)) {
        println("Буквы из вашей имени есть в списке")
    } else {
        println("Вашей имени в списке невозможно собрать")
    }
}

fun checkName(names: List<String>, userName: String): Boolean {
    val userNameLetters = userName.toLowerCase().toSet()

    for (letter in userNameLetters) {
        var found = false
        for (name in names) {
            if (name.toLowerCase().contains(letter)) {
                found = true
                break
            }
        }
        if (!found) {
            return false
        }
    }

    return true
}