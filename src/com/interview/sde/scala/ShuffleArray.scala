//https://leetcode.com/problems/shuffle-the-array/
object ShuffleArray {
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    val (firstHalf, secondHalf) = nums.splitAt(n)
    firstHalf.zip(secondHalf).flatMap(i => Array(i._1, i._2))
  }
}
