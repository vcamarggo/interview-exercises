import scala.annotation.tailrec

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
object StepsToReduceToZero {
  @tailrec def numberOfSteps(num: Int, steps: Int = 0): Int = {
    if (num == 0)
      return steps
    if (num % 2 == 0)
      numberOfSteps(num / 2, steps + 1)
    else
      numberOfSteps(num - 1, steps + 1)
  }
}
