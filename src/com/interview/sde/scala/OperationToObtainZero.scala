import scala.annotation.tailrec
//https://leetcode.com/problems/count-operations-to-obtain-zero/
object OperationToObtainZero {


  @tailrec def countOperations(num1: Int, num2: Int, op: Int = 0): Int = {
    if (num1 == 0 || num2 == 0)
      return op
    if (num1 >= num2)
      countOperations(num1 - num2, num2, op + 1)
    else
      countOperations(num1, num2 - num1, op + 1)
  }
}
