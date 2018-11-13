package com.aguiot.Boggle

case class Point(x: Int, y: Int) {
  def moves(trav: Seq[Point]): Seq[Option[Point]] = {
    Seq(
      if (y < 3 && !trav.contains(Point(x ,y + 1))) Some(Point(x , y + 1)) else None,
      if (x < 3 && !trav.contains(Point(x + 1, y))) Some(Point(x + 1, y)) else None,
      if (y > 0 && !trav.contains(Point(x, y - 1))) Some(Point(x, y - 1)) else None,
      if (x > 0 && !trav.contains(Point(x - 1, y))) Some(Point(x - 1, y)) else None)
  }
}