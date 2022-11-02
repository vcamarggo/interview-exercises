package search

//https://leetcode.com/problems/unique-number-of-occurrences/
object NumberMatchesOccurences {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val numberCount = arr.groupBy(identity).view.mapValues(_.length)
    numberCount.keys.size == numberCount.view.values.toSet.size
  }
}
