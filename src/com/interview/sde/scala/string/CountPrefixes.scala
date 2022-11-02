package string

//https://leetcode.com/problems/count-prefixes-of-a-given-string/
object CountPrefixes {
  def countPrefixes(words: Array[String], s: String): Int = {
    words.count(s.startsWith)
  }
}
