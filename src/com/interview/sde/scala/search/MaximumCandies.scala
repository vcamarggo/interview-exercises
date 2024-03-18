package search

import scala.collection.mutable

//https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
object MaximumCandies {
  def maxCandies(status: Array[Int], candies: Array[Int], keys: Array[Array[Int]], containedBoxes: Array[Array[Int]], initialBoxes: Array[Int]): Int = {
    val CAN_OPEN = 1

    val boxesToOpen = mutable.Stack[Int]()
    val boxesMissingKey = mutable.Set[Int]()

    var total = 0

    boxesToOpen.addAll(initialBoxes)

    while (boxesToOpen.nonEmpty) {
      val currentBox = boxesToOpen.removeHead()
      if (status(currentBox) == CAN_OPEN) {
        total += candies(currentBox)
        keys(currentBox).foreach(newKey => {

          //If tried to open previously and have not succeeded,
          //re-add them to the queue since we have the key
          if (boxesMissingKey.contains(newKey) && status(newKey) != CAN_OPEN) {
            boxesToOpen.addOne(newKey)
            boxesMissingKey.remove(newKey)
          }
          //Set the status to open was he now have the key
          status(newKey) = CAN_OPEN
        })
        //Add all contained boxes to the processing queue
        boxesToOpen.addAll(containedBoxes(currentBox))
      } else {
        //Add to missing key since we don't have the key now
        boxesMissingKey.addOne(currentBox)
      }
    }
    total
  }

  def main(args: Array[String]): Unit = {
    println(
      maxCandies(
        Array(1, 0, 1, 0),
        Array(7, 5, 4, 100), Array(Array[Int](), Array[Int](), Array(1), Array[Int]()),
        Array(Array(1, 2), Array(3), Array[Int](), Array[Int]()),
        Array(0)
      )
    )
    println(
      maxCandies(
        Array(1, 0, 0, 0, 0, 0),
        Array(1, 1, 1, 1, 1, 1),
        Array(Array(1, 2, 3, 4, 5), Array[Int](), Array[Int](), Array[Int](), Array[Int](), Array[Int]()),
        Array(Array(1, 2, 3, 4, 5), Array[Int](), Array[Int](), Array[Int](), Array[Int](), Array[Int]()),
        Array(0)
      )
    )
    println(
      maxCandies(
        Array(1, 1, 1),
        Array(100, 1, 100),
        Array(Array[Int](), Array(0, 2), Array[Int]()),
        Array(Array[Int](), Array[Int](), Array[Int]()),
        Array(1)
      )
    )
    println(
      maxCandies(
        Array(1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0),
        Array(732, 320, 543, 300, 814, 568, 947, 685, 142, 111, 805, 233, 813, 306, 55, 1, 290, 944, 36, 592, 150, 596, 372, 299, 644, 445, 605, 202, 64, 807, 753, 731, 552, 766, 119, 862, 453, 136, 43, 572, 801, 518, 936, 408, 515, 215, 492, 738, 154),
        Array(Array(42, 2, 24, 8, 39, 16, 46), Array(20, 39, 46, 21, 32, 31, 43, 16, 12, 23, 3), Array(21, 14, 30, 2, 11, 13, 27, 37, 4, 48), Array(16, 17, 15, 6), Array(31, 14, 3, 32, 35, 19, 42, 43, 44, 29, 25, 41), Array(7, 39, 2, 3, 40, 28, 37, 35, 43, 22, 6, 23, 48, 10, 21, 11), Array(27, 1, 37, 3, 45, 32, 30, 26, 16, 2, 35, 19, 31, 47, 5, 14), Array(28, 35, 23, 17, 6), Array(6, 39, 34, 22), Array(44, 29, 36, 31, 40, 22, 9, 11, 17, 25, 1, 14, 41), Array(39, 37, 11, 36, 17, 42, 13, 12, 7, 9, 43, 41), Array(23, 16, 32, 37), Array(36, 39, 21, 41), Array(15, 27, 5, 42), Array(11, 5, 18, 48, 25, 47, 17, 0, 41, 26, 9, 29), Array(18, 36, 40, 35, 12, 33, 11, 5, 44, 14, 46, 7), Array(48, 22, 11, 33, 14), Array(44, 12, 3, 31, 25, 15, 18, 28, 42, 43), Array(36, 9, 0, 42), Array(1, 22, 3, 24, 9, 11, 43, 8, 35, 5, 41, 29, 40), Array(15, 47, 32, 28, 33, 31, 4, 43), Array(1, 11, 6, 37, 28), Array(46, 20, 47, 32, 26, 15, 11, 40), Array(33, 45, 26, 40, 12, 3, 16, 18, 10, 28, 5), Array(14, 6, 4, 46, 34, 9, 33, 24, 30, 12, 37), Array(45, 24, 18, 31, 32, 39, 26, 27), Array(29, 0, 32, 15, 7, 48, 36, 26, 33, 31, 18, 39, 23, 34, 44), Array(25, 16, 42, 31, 41, 35, 26, 10, 3, 1, 4, 29), Array(8, 11, 5, 40, 9, 18, 10, 16, 26, 30, 19, 2, 14, 4), Array[Int](), Array(0, 20, 17, 47, 41, 36, 23, 42, 15, 13, 27), Array(7, 15, 44, 38, 41, 42, 26, 19, 5, 47), Array[Int](), Array(37, 22), Array(21, 24, 15, 48, 33, 6, 39, 11), Array(23, 7, 3, 29, 10, 40, 1, 16, 6, 8, 27), Array(27, 29, 25, 26, 46, 15, 16), Array(33, 40, 10, 38, 13, 19, 17, 23, 32, 39, 7), Array(35, 3, 39, 18), Array(47, 11, 27, 23, 35, 26, 43, 4, 22, 38, 44, 31, 1, 0), Array[Int](), Array(18, 43, 46, 9, 15, 3, 42, 31, 13, 4, 12, 39, 22), Array(42, 45, 47, 18, 26, 41, 38, 9, 0, 35, 8, 16, 29, 36, 31), Array(3, 20, 29, 12, 46, 41, 23, 4, 9, 27), Array(19, 33), Array(32, 18), Array(17, 28, 7, 35, 6, 22, 4, 43), Array(41, 31, 20, 28, 35, 32, 24, 23, 0, 33, 18, 39, 29, 30, 16), Array(43, 47, 46)),
        Array(Array(14), Array[Int](), Array(26), Array(4, 47), Array[Int](), Array(6), Array(39, 43, 46), Array(30), Array[Int](), Array[Int](), Array(0, 3), Array[Int](), Array[Int](), Array[Int](), Array[Int](), Array(27), Array[Int](), Array[Int](), Array[Int](), Array[Int](), Array(12), Array[Int](), Array[Int](), Array(41), Array[Int](), Array(31), Array(20, 29), Array(13, 35), Array(18), Array(10, 40), Array[Int](), Array(38), Array[Int](), Array[Int](), Array(19), Array(5), Array[Int](), Array[Int](), Array(11), Array(1), Array(15), Array[Int](), Array[Int](), Array[Int](), Array(24), Array[Int](), Array[Int](), Array[Int](), Array[Int]()),
        Array(2, 7, 8, 9, 16, 17, 21, 22, 23, 25, 28, 32, 33, 34, 36, 37, 42, 44, 45, 48)
      )
    )
  }
}
