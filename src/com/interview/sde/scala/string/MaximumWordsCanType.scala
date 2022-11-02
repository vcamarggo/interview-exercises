package string

//https://leetcode.com/problems/maximum-number-of-words-you-can-type/
object MaximumWordsCanType {
  def canBeTypedWords(text: String, brokenLetters: String): Int = {
    text.split(" ").count(_.toSet.intersect(brokenLetters.toSet).isEmpty)
  }

  def main(args: Array[String]): Unit = {
    println(canBeTypedWords("hello world", "ad"))
  }
}
