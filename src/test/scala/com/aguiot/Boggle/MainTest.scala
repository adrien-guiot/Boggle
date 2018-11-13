package com.aguiot.Boggle

import com.aguiot.Boggle.main._
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class MainTest extends FlatSpec{

  val board: Seq[Seq[Char]] = Seq(
    Seq('C', 'A', 'T', 'U'),
    Seq('Z', 'V', 'O', 'B'),
    Seq('A', 'S', 'U', 'R'),
    Seq('T', 'Q', 'R', 'E'))


  "Solve" should "return CAT, CATOBU, and TOUR" in {
    val dict = Seq("CAT", "TOUR", "CATOBU")

    solve(board, dict) should contain only ("CAT", "TOUR", "CATOBU")

  }

  "Search" should "find CAT and CATOBU" in {
    val dict = Seq("CAT", "TOUR", "CATOBU")


    search(board, dict, Seq(), Point(0, 0), "") should contain only ("CAT", "CATOBU")

  }

  it should "not return TOUR twice" in {
    val dict = Seq("CAT", "TOUR", "CATOBU")

    search(board, dict, Seq(), Point(2, 0), "") should have length 1


  }

}
