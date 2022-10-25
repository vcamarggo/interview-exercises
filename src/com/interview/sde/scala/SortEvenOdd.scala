//https://leetcode.com/problems/sort-array-by-parity/
object SortEvenOdd {
  def sortArrayByParity(nums: Array[Int]): Array[Int] = {
    nums.sortBy(_ % 2)
  }

  def main(args: Array[String]): Unit = {
    println(sortArrayByParity(Array(3,1,2,4)).mkString)
  }
}
