package sorting

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
object SortByThe1BitsCount {
  def sortByBits(arr: Array[Int]): Array[Int] = {
    //Sort by count of 1 in the binary string, if tied, sort by the decimal value
    arr.sortBy(i => (i.toBinaryString.count(_ == '1'), i) )
  }
}
