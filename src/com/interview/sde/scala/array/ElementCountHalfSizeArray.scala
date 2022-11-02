package array

//https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
object ElementCountHalfSizeArray {
  def repeatedNTimes(nums: Array[Int]): Int = {
    nums.groupBy(identity).view.mapValues(_.length).find(_._2 == nums.length / 2).get._1
  }
}
