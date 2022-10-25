//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
object MakeArrayZeroSubtractingAmount {
  def minimumOperations(nums: Array[Int]): Int = {
    nums.filter(_ > 0).distinct.length
  }
}
