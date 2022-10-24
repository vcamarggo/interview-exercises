//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
object EquivalentArrayString {
  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {
    word1.mkString == word2.mkString
  }
}
