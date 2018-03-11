package rps

import org.scalatest.{FlatSpec, Matchers}

class GameRunnerSpec extends FlatSpec with Matchers with MoveChooserMock {
  it should "Pass all scenario if player 1 move passed" in {
    GameRunner(moveChooserWhichReturns(Paper)).play(player1Move = Scissors)._1 shouldBe Player1Wins
    GameRunner(moveChooserWhichReturns(Rock)).play(player1Move = Rock)._1 shouldBe GameTied
    GameRunner(moveChooserWhichReturns(Scissors)).play(player1Move = Rock)._1 shouldBe Player1Wins
  }

  it should "Pass all scenario if no moves passed" in {
    GameRunner(moveChooserWhichReturns(Paper, Scissors)).play()._1 shouldBe Player2Wins
    GameRunner(moveChooserWhichReturns(Rock, Rock)).play()._1 shouldBe GameTied
    GameRunner(moveChooserWhichReturns(Scissors, Rock)).play()._1 shouldBe Player2Wins
  }
}
