//https://leetcode.com/problems/find-the-highest-altitude/
object NetAltitude {
  def largestAltitude(gain: Array[Int]): Int = {
    gain.scanLeft(0)(_+_).max
  }

  def main(args: Array[String]): Unit = {
    println(largestAltitude(Array(-5,1,5,0,-7)))
  }
}
