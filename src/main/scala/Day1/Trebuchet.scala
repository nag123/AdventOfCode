package Day1

object Trebuchet extends App{

  val regex = """\d+""".r

  var FindingDigitValue = io.Source
    .fromResource("input.txt")
    .getLines
    .flatMap {
       listofvalue =>
         val  digits = regex.findAllIn(listofvalue).toList.map(_.toInt)
         for(f <- digits.headOption ;l <- digits.lastOption) yield f*10+l
}.sum
println(FindingDigitValue)



}
