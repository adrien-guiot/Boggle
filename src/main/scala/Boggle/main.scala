package Boggle

object main {

  def main (args: Array[String]): Unit = {

  }

  function solve(board, dict) {
    let result = []
    for (row in board) { //y
      for (car in row) { //x
        point = [car, row]
        result += search(point, board, dict, "")
      }
    }
    return result
  }
}
