package com.aguiot.Boggle

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class PointTest extends FlatSpec {

  "A Point" should "be able to navigate to its surrounding" in {
    val p = Point(2, 2)

    val result = p.moves(Seq())

    result.flatten should contain only (
      Point(2, 3),
      Point(3, 2),
      Point(2, 1),
      Point(1, 2))
  }

  it should "be able to navigate to its surrounding with over max" in {
    val p = Point(3, 3)

    val result = p.moves(Seq())

    result.flatten should contain only (
      Point(3, 2),
      Point(2, 3))
  }

  it should "be able to navigate to its surrounding with under min" in {
    val p = Point(0, 0)

    val result = p.moves(Seq())

    result.flatten should contain only (
      Point(1, 0),
      Point(0, 1))
  }

  it should "be able to navigate to its surrounding with a not empty trav" in {
    val p = Point(1, 1)

    val result = p.moves(Seq(Point(1, 0), Point(1, 2)))

    result.flatten should contain only (
      Point(2, 1),
      Point(0, 1))
  }



}
