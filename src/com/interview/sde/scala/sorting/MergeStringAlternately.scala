package sorting

//https://leetcode.com/problems/merge-strings-alternately/
object MergeStringAlternately {
  def mergeAlternately(word1: String, word2: String): String = {
    word1.zipAll(word2, "", "").foldLeft("")((a, b) => a.concat(b._1.toString).concat(b._2.toString))
  }

  def main(args: Array[String]): Unit = {
    println(mergeAlternately("abc", "pqr"))
  }
}
