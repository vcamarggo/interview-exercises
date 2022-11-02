package sorting

//https://leetcode.com/problems/orderly-queue/
object KKickSort {
  def orderlyQueue(s: String, k: Int): String = {
    if (k == 1) {
      // from all the possible rotations (sliding window), get the lexicographical minimum
      (s + s).sliding(s.length).min
    } else {
      s.sorted
    }
  }

  def main(args: Array[String]): Unit = {
    println(orderlyQueue("cba", 1))
    println(orderlyQueue("baaca", 3))
  }
}
