import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var isRunning = true

    while (isRunning) {
        println("Введите первое число:")
        val num1 = readNumber(scanner)

        println("Введите оператор (+, -, *, /, %):")
        val operator = scanner.next()

        if (operator == "%") {
            println("Введите процент:")
            val percent = readNumber(scanner)
            println("Результат: " + calculatePercentage(num1, percent))
        } else {
            println("Введите второе число:")
            val num2 = readNumber(scanner)
            println("Результат: " + calculate(num1, operator, num2))
        }

        println("Хотите продолжить? (да/нет)")
        val continueChoice = scanner.next()

        if (continueChoice.equals("нет", ignoreCase = true)) {
            isRunning = false
        }
    }
}

fun readNumber(scanner: Scanner): Number {
    return if (scanner.hasNextDouble()) {
        scanner.nextDouble()
    } else {
        scanner.nextInt()
    }
}

fun calculate(num1: Number, operator: String, num2: Number): Number {
    return when (operator) {
        "+" -> num1.toDouble() + num2.toDouble()
        "-" -> num1.toDouble() - num2.toDouble()
        "*" -> num1.toDouble() * num2.toDouble()
        "/" -> num1.toDouble() / num2.toDouble()
        else -> throw IllegalArgumentException("Некорректный оператор")
    }
}

fun calculatePercentage(num: Number, percent: Number): Double {
    return num.toDouble() * (percent.toDouble() / 100)
}