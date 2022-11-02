package datastructure

import scala.collection.mutable

//https://leetcode.com/problems/number-of-recent-calls/
class RecentCounter() {

  val dataStore: mutable.TreeSet[Int] = mutable.TreeSet()

  def ping(t: Int): Int = {
    dataStore.add(t)
    dataStore.rangeFrom(t - 3000).size
  }

}