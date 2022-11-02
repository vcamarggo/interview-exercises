package stack

//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
object MaximumParenthesesDepth {
  def maxDepth(s: String): Int = {
// Imperative
//    var depth = 0
//    var max = 0
//    s.foreach {
//      case '(' => depth += 1
//      case ')' => max.max(depth); depth -= 1;
//      case _ =>
//    }
//    max

    //Functional
    s.scanLeft(0) { case (depth, ch) =>
      ch match {
        case '(' => depth + 1
        case ')' => depth - 1;
        case _ => depth
      }
    }.max
  }

  def main(args: Array[String]): Unit = {
    println(maxDepth("(1+(2*3)+((8)/4))+1"))
  }
}
