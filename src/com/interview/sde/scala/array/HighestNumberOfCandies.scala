package array

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
object HighestNumberOfCandies {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
    candies.toList.map(_ + extraCandies >= candies.max)
  }

}
