package Day1

import scala.util.matching.Regex

object Trebuchet extends App{

  val regexpart1 = """\d+""".r

  var part1 = io.Source
    .fromResource("input.txt")
    .getLines
    .flatMap {
       listofvalue =>
         val  digits = regexpart1.findAllIn(listofvalue).toList.map(_.toInt)
         for(f <- digits.headOption ;l <- digits.lastOption) yield f*10+l
}.sum
println(part1)

  def parseWordsToNumbers(value: String): Int = value match {
    case "one" => 1
    case "two" => 2
    case "three" => 3
    case "four" => 4
    case "five" => 5
    case "six" => 6
    case "seven" => 7
    case "eight" => 8
    case "nine" => 9
    case d => d.charAt(0) - '0'
  }

  var input = io.Source
    .fromResource("input.txt")
    .getLines.toList
  def firstDigitInString(line: String, regex: Regex): Option[Int] = regex.findFirstIn(line).map(parseWordsToNumbers)

  def lastDigitInString(line: String, regex: Regex): Int = line.indices.map( line.substring).flatMap(firstDigitInString(_, regex)).last

  def CalculatedcalibrationValue(line: String, regex: Regex): Int = 10 * firstDigitInString(line, regex).get + lastDigitInString(line, regex)

  val part2 = input.map(CalculatedcalibrationValue(_, """one|two|three|four|five|six|seven|eight|nine|\d""".r)).sum

  println(part2)
}
