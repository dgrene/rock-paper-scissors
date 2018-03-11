package rps

import scala.util.Random

case class GameRunner(moveChooser: MoveChooser) {
  def play(player1Move: Move = moveChooser.nextMove(), player2Move: Move = moveChooser.nextMove()): (GameResult, Move, Move) = {
    (GameEngine.play(player1Move, player2Move), player1Move, player2Move)
  }
}

case class MoveChooser(random: Random) {
  def nextMove(): Move = random.shuffle(Move.values).head
}