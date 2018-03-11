package rps

object GameEngine {
  def play(player1Move: Move, player2Move: Move): GameResult =
    player1Move.winsAgainst(player2Move) match {
      case _: Wins.type => Player1Wins
      case _: Loses.type => Player2Wins
      case _: MoveTied.type => GameTied
    }
}

sealed trait GameResult

case object Player1Wins extends GameResult {
  override def toString: String = "Player 1 wins the game!"
}

case object Player2Wins extends GameResult {
  override def toString: String = "Player 2 wins the game!"
}

case object GameTied extends GameResult {
  override def toString: String = "The game is tied!"
}
