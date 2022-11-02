package stack

import scala.collection.mutable

//https://leetcode.com/problems/parsing-a-boolean-expression/
object ParseBooleanExpression {

  val stack: mutable.Stack[Char] = mutable.Stack()
  val operators: Set[Char] = Set('&', '|', '!')

  def processExpression(): Unit = {
    val operands = stack.popWhile(!operators.contains(_))
    stack.pop() match {
      case '&' => stack.push(if (operands.contains('f')) 'f' else 't')
      case '|' => stack.push(if (operands.contains('t')) 't' else 'f')
      case '!' => stack.push(if (operands.head == 't') 'f' else 't')
    }
  }

  def parseBoolExpr(expression: String): Boolean = {
    expression.foreach {
      case '(' => None
      case ',' => None
      case ')' => processExpression() //handle stack until operator
      case _@ch => stack.push(ch)
    }
    stack.pop() == 't'
  }

  def main(args: Array[String]): Unit = {
    //    println(parseBoolExpr("&(|(f))"))
    //    println(parseBoolExpr("!(!(t))"))
    //    println(parseBoolExpr("|(f,f,f,t)"))
    println(parseBoolExpr("|(f,!(f),f,t)"))
    //    println(parseBoolExpr("!(&(f,t))"))
  }
}
