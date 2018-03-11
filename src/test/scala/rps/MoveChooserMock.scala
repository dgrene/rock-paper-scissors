package rps

import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar

trait MoveChooserMock extends MockitoSugar {
  def moveChooserWhichReturns(moves: Move*): MoveChooser = {
    val moveChooser = mock[MoveChooser]
    when(moveChooser.nextMove()).thenReturn(moves.head, moves.tail: _*)
    moveChooser
  }
}
