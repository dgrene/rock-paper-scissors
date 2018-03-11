package rps

case object Move {
  val values: List[Move] = List(Rock, Paper, Scissors, Lizard, Spock)
//  lazy val numberToMoveName: SortedMap[Int, String] = {
//    val elements = values
//      .zipWithIndex
//      .map { case (move, index) => (index + 1, move.toString) }
//      .sortBy(_._1)
//
//    SortedMap(elements: _*)
//  }
//
//  def findByNumber(number: Int): Move = values(number - 1)
}

sealed trait Move {
  def winsAgainst(opponentMove: Move): MovesResult
}

case object Rock extends Move {
  def winsAgainst(opponentMove: Move): MovesResult = opponentMove match {
    case _: Rock.type => MoveTied
    case _: Scissors.type => Wins
    case _: Lizard.type => Wins
    case _: Paper.type => Loses
    case _: Spock.type => Loses
  }
}

case object Paper extends Move {
  def winsAgainst(opponentMove: Move): MovesResult = opponentMove match {
    case _: Rock.type => Wins
    case _: Spock.type => Wins
    case _: Scissors.type => Loses
    case _: Lizard.type => Loses
    case _: Paper.type => MoveTied
  }
}

case object Scissors extends Move {
  def winsAgainst(opponentMove: Move): MovesResult = opponentMove match {
    case _: Rock.type => Loses
    case _: Spock.type => Loses
    case _: Scissors.type => MoveTied
    case _: Paper.type => Wins
    case _: Lizard.type => Wins
  }
}

case object Lizard extends Move {
  def winsAgainst(opponentMove: Move): MovesResult = opponentMove match {
    case _: Rock.type => Loses
    case _: Scissors.type => Loses
    case _: Lizard.type => MoveTied
    case _: Spock.type => Wins
    case _: Paper.type => Wins
  }
}

case object Spock extends Move {
  def winsAgainst(opponentMove: Move): MovesResult = opponentMove match {
    case _: Paper.type => Loses
    case _: Lizard.type => Loses
    case _: Spock.type => MoveTied
    case _: Rock.type => Wins
    case _: Scissors.type => Wins
  }
}

sealed trait MovesResult
case object Wins extends MovesResult
case object Loses extends MovesResult
case object MoveTied extends MovesResult
