package Boggle

object main {

  def main(args: Array[String]): Unit = {

    val board: Seq[Seq[Char]] = Seq(
      Seq('C', 'A', 'T', 'U'),
      Seq('Z', 'V', 'O', 'B'),
      Seq('A', 'S', 'U', 'R'),
      Seq('T', 'Q', 'R', 'E'))


    val dict = Seq("CAT", "TOUR", "CATOBU")

    println(solve(board, dict))
  }

  def solve(board: Seq[Seq[Char]], dict: Seq[String]): Seq[String] = {

    val myArray = for (x <- 0 until 4; y <- 0 until 4) yield search(board, dict, Seq(), Point(x, y), "")

    myArray.flatten
  }

  def search(board: Seq[Seq[Char]], dict: Seq[String], trav: Seq[Point], point: Point, str: String): Seq[String] = {
    val newStr = str + board(point.x)(point.y)
    val result: Seq[String] = if (dict.contains(newStr)) Seq(newStr) else Seq()

    (result ++ point.moves(trav).flatten.map(search(board, dict, trav :+ point, _, newStr)).flatten).distinct

  }

}
