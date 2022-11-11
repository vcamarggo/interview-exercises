package search

//https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
object StudentsDoingHomework {
  def busyStudent(startTime: Array[Int], endTime: Array[Int], queryTime: Int): Int = {
    endTime.indices.count(i => endTime(i) >= queryTime && startTime(i) <= queryTime)
  }
}
