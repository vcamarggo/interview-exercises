//https://leetcode.com/problems/jewels-and-stones/
object JewelsStones {
  def main(args: Array[String]): Unit = {
    println(numJewelsInStones("aA", "aAAbbbb"))
  }

  def numJewelsInStones(jewels: String, stones: String): Int = {
    stones.count(jewels.contains(_))
  }
}
