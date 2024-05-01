val input = io.Source.fromResource("day2").getLines().toList
//input foreach println

type Hand = Map[String,Int]
//Game 1: 19 blue, 12 red; 19 blue, 2 green, 1 red; 13 red, 11 blue
//Game 59: 2 red, 6 blue, 1 green; 1 green, 12 blue; 2 red
case class Game(id : Int, hands : List[Hand])

val games = input.map
{
  case s"Game $id: $handsStr" =>
    var hands = handsStr.split("; ").toList
      .map {
        str => str.split(", ").collect {
          case s"$n blue" => "blue" -> n.toInt
          case s"$n red" => "red" -> n.toInt
          case s"$n green" => "green" -> n.toInt
        }.toMap.withDefaultValue(0)
      }
    Game(id.toInt,hands )
}

println(games.map(_.hands))

val possibleGames = games
  .filter(_.hands.map(_("red")).max <= 12)
  .filter(_.hands.map(_("green")).max <= 13)
  .filter(_.hands.map(_("blue")).max <= 14)

val ans = possibleGames.map(_.id).sum

def power(game : Game) : Int =
  game.hands.map(_("red")).max * game.hands.map(_("green")).max * game.hands.map(_("blue")).max

  games.map(power).sum