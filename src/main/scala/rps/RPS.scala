package rps

import scala.util.Random

object RPS extends App {
  private val moveChooser = MoveChooser(new Random())
  private val gameRunner = GameRunner(moveChooser)
  private val numberOfRounds = 100
  private var player1WinsCount = 0
  private var player2WinsCount = 0
  private var gameTiedcount = 0
  private val player1Move = Lizard

  for (i <- 0 until numberOfRounds) {
    print("\nRound : " + i)
    calScores(gameRunner.play(player1Move))
  }

  println(
    s"""
       |Final Scores :-
       | Player 1 wins $player1WinsCount of $numberOfRounds games
       | Player 2 wins $player2WinsCount of $numberOfRounds games
       | Tied: $gameTiedcount of $numberOfRounds games
     """.stripMargin
  )

  private def calScores(result: (GameResult, Move, Move)): Unit = {
    val (gameResult, player1Move, player2Move) = result
    gameResult match {
      case Player1Wins => player1WinsCount += 1
      case Player2Wins => player2WinsCount += 1
      case GameTied => gameTiedcount += 1
    }
    println(
      s"""
         | Player 1 move: $player1Move
         | Player 2 move: $player2Move
         | ===> $gameResult""".stripMargin)
  }
}
