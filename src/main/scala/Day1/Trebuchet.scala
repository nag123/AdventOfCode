package Day1

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

}
