package string

//https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
object CellRangeExcel {
  def cellsInRange(s: String): List[String] = {
    val startLetter = s(0)
    val endLetter = s(3)
    val startIndex = s(1)
    val endIndex = s(4)
    (for (ch <- startLetter to endLetter;
          nbr <- startIndex to endIndex) yield {
      s"$ch$nbr"
    }).toList
  }

  def main(args: Array[String]): Unit = {
    println(cellsInRange("K1:L2"))
  }
}
