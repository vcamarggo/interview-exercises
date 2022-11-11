package sorting

//https://leetcode.com/problems/sort-the-people/
object SortPeople {
  def sortPeople(names: Array[String], heights: Array[Int]): Array[String] = {
    names.zip(heights).sortBy(-_._2).map(_._1)
  }
}
