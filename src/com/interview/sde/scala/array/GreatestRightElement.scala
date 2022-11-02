package array

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
import scala.math.max

object GreatestRightElement {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    arr.tail.scanRight(-1)(max)
  }

  def main(args: Array[String]): Unit = {
    println(replaceElements(Array(17, 18, 5, 4, 6, 1)).mkString)
  }
}
