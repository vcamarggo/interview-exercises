package string

//https://leetcode.com/problems/counting-words-with-a-given-prefix
object CountStartsWithPrefix {
  def prefixCount(words: Array[String], pref: String): Int = {
    words.count(_.startsWith(pref))
  }
}
