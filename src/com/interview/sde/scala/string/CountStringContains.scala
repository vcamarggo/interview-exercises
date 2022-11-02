package string

//https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
object CountStringContains {
  def numOfStrings(patterns: Array[String], word: String): Int = {
    patterns.count(word.contains(_))
  }
}
