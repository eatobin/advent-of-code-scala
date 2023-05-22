package AdventOfCode2019

import org.scalatest.funsuite.AnyFunSuite

class Day01Suite extends AnyFunSuite:
  val sample: Seq[Int] = Seq(100756)

  val data: Seq[Int] = io.Source
    .fromResource("AdventOfCode2019/Day01.txt")
    .getLines()
    .map(_.toInt)
    .toSeq

  test("Part 1 should handle sample input correctly") {
    assert(Day01.part1(sample) == 33_583)
  }

  test("Part 2 should handle sample input correctly") {
    assert(Day01.part2(sample) == 50_346)
  }
