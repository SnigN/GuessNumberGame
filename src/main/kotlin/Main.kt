import kotlin.random.Random

class GuessNumberGame {
    private val secretNumber: Int = Random.nextInt(101)
    private var currentPlayer: Player = Player.HUMAN

    enum class Player {
        HUMAN, COMPUTER
    }

    fun play() {
        println("Гра \"Вгадай число\"")
        println("Я загадав число від 0 до 100. Спробуйте вгадати!")

        while (true) {
            when (currentPlayer) {
                Player.HUMAN -> {
                    val guess = getUserGuess()
                    if (guess == secretNumber) {
                        println("Вітаємо! Ви вгадали число $secretNumber.")
                        switchPlayer()
                    } else {
                        println(if (guess < secretNumber) "Моє число більше." else "Моє число менше.")
                    }
                }
                Player.COMPUTER -> {
                    val guess = getComputerGuess()
                    println("Комп'ютер вгадав число $guess.")
                    if (guess == secretNumber) {
                        println("Комп'ютер виграв! Я загадав число $secretNumber.")
                        switchPlayer()
                    }
                }
            }
        }
    }

    private fun getUserGuess(): Int {
        print("Ваш варіант: ")
        return readLine()?.toIntOrNull() ?: 0
    }

    private fun getComputerGuess(): Int {
        return Random.nextInt(101)
    }

    private fun switchPlayer() {
        currentPlayer = if (currentPlayer == Player.HUMAN) Player.COMPUTER else Player.HUMAN
    }
}

fun main() {
    val game = GuessNumberGame()
    game.play()
}
