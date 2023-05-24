package AdventOfCode2019

import scala.annotation.tailrec

object Day01:
  private def fuel(mass: Int): Int = (mass / 3) - 2
  private def tsiolkovsky(mass: Int): Int =
    if mass < 7 then 0 else fuel(mass) + tsiolkovsky(fuel(mass))

  def part1(input: Seq[Int]): Int = input.map(fuel).sum
  def part2(input: Seq[Int]): Int = input.map(tsiolkovsky).sum

  private def gasPlus2(mass: Int): Int =
    @tailrec
    def fuelAccumulator(m: Int, accum: Int): Int =
      val newGas: Int = fuel(m)
      if newGas > 0
      then fuelAccumulator(m = newGas, accum = accum + newGas)
      else accum

    fuelAccumulator(m = mass, accum = 0)

  def part3(input: Seq[Int]): Int = input.map(gasPlus2).sum

  def main(args: Array[String]): Unit =
    val data = io.Source
      .fromResource("AdventOfCode2019/Day01.txt")
      .getLines()
      .map(_.toInt)
      .toSeq
    println(part1(data)) // 3337766
    println(part2(data)) // 5003788
    println(part3(data)) // 5003788
