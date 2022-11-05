package array

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
object CountEvenDigitsNumbers {
  def findNumbers(nums: Array[Int]): Int = {
    nums.count(_.toString.length % 2 == 0)
  }
}
