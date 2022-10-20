//https://leetcode.com/problems/decompress-run-length-encoded-list/
object DecompressLengthEncodedList {
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
//    nums match {
//      case Array(e1, e2, tail@_*) => Array.fill(e1)(e2).concat(decompressRLElist(tail.toArray))
//      case _ => Array()
//    }
    nums.grouped(2).flatMap(pair => Array.fill(pair(0))(pair(1))).toArray
  }

  def main(args: Array[String]): Unit = {
    print(decompressRLElist(Array(1, 2, 3, 4)).mkString)

  }
}
