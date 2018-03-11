package rps

import org.scalatest.{FlatSpec, Matchers}

class GameEngineSpec extends FlatSpec with Matchers {

  private def assertResult(player1Move: Move, player2Move: Move, expectedResult: GameResult) = {
    GameEngine.play(player1Move, player2Move) shouldBe expectedResult
  }

  it should "Pass all scenario if Player 1 chooses Lizard" in {
    assertResult(Lizard, Spock, Player1Wins)
    assertResult(Lizard, Paper, Player1Wins)
    assertResult(Lizard, Rock, Player2Wins)
    assertResult(Lizard, Scissors, Player2Wins)
    assertResult(Lizard, Lizard, GameTied)
  }

  it should "Pass all scenario if Player 1 chooses Scissors" in {
    assertResult(Scissors, Spock, Player2Wins)
    assertResult(Scissors, Paper, Player1Wins)
    assertResult(Scissors, Rock, Player2Wins)
    assertResult(Scissors, Scissors, GameTied)
    assertResult(Scissors, Lizard, Player1Wins)
  }
  it should "Pass all scenario if Player 1 chooses Rock" in {
    assertResult(Rock, Spock, Player2Wins)
    assertResult(Rock, Paper, Player2Wins)
    assertResult(Rock, Rock, GameTied)
    assertResult(Rock, Scissors, Player1Wins)
    assertResult(Rock, Lizard, Player1Wins)
  }
  it should "Pass all scenario if Player 1 chooses Paper" in {
    assertResult(Paper, Spock, Player1Wins)
    assertResult(Paper, Paper, GameTied)
    assertResult(Paper, Rock, Player1Wins)
    assertResult(Paper, Scissors, Player2Wins)
    assertResult(Paper, Lizard, Player2Wins)
  }
  it should "Pass all scenario if Player 1 chooses Spock" in {
    assertResult(Spock, Spock, GameTied)
    assertResult(Spock, Paper, Player2Wins)
    assertResult(Spock, Rock, Player1Wins)
    assertResult(Spock, Scissors, Player1Wins)
    assertResult(Spock, Lizard, Player2Wins)
  }
}
