package stack

import scala.collection.mutable

//https://leetcode.com/problems/maximum-frequency-stack/
class MaximumFrequencyStack {
  val dataStore: mutable.TreeMap[Int, mutable.Stack[Int]] = mutable.TreeMap()
  val frequencyStore: mutable.Map[Int, Int] = mutable.HashMap()

  def push(num: Int): Unit = {
    //Count the number of times num appeared
    val frequency = frequencyStore.updateWith(num)(previousValue => if (previousValue.isDefined) Some(previousValue.get + 1) else Some(1)).get
    //Add val to the stack with its frequency
    dataStore.getOrElseUpdate(frequency, mutable.Stack()).push(num)
  }

  def pop(): Int = {
    //Get the KeyValue last added (TreeMap is ordered)
    val maxFrequencyKeyValue = dataStore.last
    //Remove Key if stack is size 1
    if (maxFrequencyKeyValue._2.sizeIs == 1) {
      dataStore.remove(maxFrequencyKeyValue._1)
    }
    //Get returnValue, which is key from frequency store
    val returnValue = maxFrequencyKeyValue._2.pop()
    //Reduce the occurrences of the value as it is now being removed
    frequencyStore(returnValue) -= 1
    returnValue
  }
}
