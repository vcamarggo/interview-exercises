package string

import scala.annotation.tailrec

//https://leetcode.com/problems/replace-all-digits-with-characters/
object RepeatCharsString {
  @tailrec
  def replaceDigits(s: String, acc: String = ""): String = {
    if (s.length < 2)
      acc + s
    else
      replaceDigits(s.substring(2), acc + s.charAt(0).toString + (s.charAt(0) + s.charAt(1).asDigit).toChar)
  }

  def main(args: Array[String]): Unit = {
    println(replaceDigits("a1c1e1"))
  }
}
