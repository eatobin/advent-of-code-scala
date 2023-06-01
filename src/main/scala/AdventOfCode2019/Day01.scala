package AdventOfCode2019

import scala.annotation.tailrec

object Day01:
  extension (int: Int)
    private def fuel: Int =
      (int / 3) - 2

    private def fuelPlusFuel: Int =
      @tailrec
      def fuelAccumulator(mass: Int, accum: Int): Int =
        val newGas: Int = mass.fuel
        if newGas > 0
        then fuelAccumulator(mass = newGas, accum = accum + newGas)
        else accum
      fuelAccumulator(mass = int, accum = 0)
  end extension

  def part1(input: Seq[Int]): Int = input.map(fuel).sum
  def part2(input: Seq[Int]): Int = input.map(fuelPlusFuel).sum

  def main(args: Array[String]): Unit =
    val data = io.Source
      .fromResource("AdventOfCode2019/Day01.txt")
      .getLines()
      .map(_.toInt)
      .toSeq
    println(part1(data)) // 3337766
    println(part2(data)) // 5003788

    println(12.fuel) // 2
    println(14.fuel) // 2
    println(1969.fuel) // 654
    println(100756.fuel) // 33583

    println(14.fuelPlusFuel) // 2
    println(1969.fuelPlusFuel) // 966
    println(100756.fuelPlusFuel) // 50346
