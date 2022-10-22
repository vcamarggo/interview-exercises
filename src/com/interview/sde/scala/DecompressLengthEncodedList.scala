//https://leetcode.com/problems/decompress-run-length-encoded-list/
object DecompressLengthEncodedList {
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    //Option1
//    if(!nums.isEmpty) Array.fill(nums.head)(nums.tail.head).concat(decompressRLElist(nums.tail.tail)) else nums
    //Option 2
//    nums match {
//      case Array(e1, e2, tail@_*) => Array.fill(e1)(e2).concat(decompressRLElist(tail.toArray))
//      case _ => Array()
//    }
    //Option 3
    nums.grouped(2).flatMap(pair => Array.fill(pair(0))(pair(1))).toArray
  }

  def main(args: Array[String]): Unit = {
    print(decompressRLElist(Array(1, 2, 3, 4)).mkString)

  }
}
