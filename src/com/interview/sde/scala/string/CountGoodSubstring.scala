package string

//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
object CountGoodSubstring {
  def countGoodSubstrings(s: String): Int = {
    s.sliding(3).count(_.toSet.sizeIs == 3)
  }
}
