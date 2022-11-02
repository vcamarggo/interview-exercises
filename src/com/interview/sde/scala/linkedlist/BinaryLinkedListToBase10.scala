package linkedlist

import scala.annotation.tailrec

//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
object BinaryLinkedListToBase10 {
  @tailrec def getDecimalValue(head: ListNode, acc: String = ""): Int = {
    if (head == null) BigInt(acc, 2).toString(10).toInt else getDecimalValue(head.next, acc + head.x.toString)
  }
}
