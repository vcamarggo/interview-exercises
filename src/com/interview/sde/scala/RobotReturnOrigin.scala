//https://leetcode.com/problems/robot-return-to-origin/
object RobotReturnOrigin {
  def judgeCircle(moves: String): Boolean = {
    val directions = moves.groupBy(identity).view.mapValues(_.length)
    directions.getOrElse('U' ,0) == directions.getOrElse('D',0) && directions.getOrElse('L', 0) == directions.getOrElse('R', 0)
  }

  def main(args: Array[String]): Unit = {
    print(judgeCircle("UDUDLRLRLRLR"))
  }
}
