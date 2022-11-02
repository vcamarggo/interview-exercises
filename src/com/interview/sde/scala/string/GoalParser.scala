package string

//https://leetcode.com/problems/goal-parser-interpretation/
object GoalParser {
  def interpret(command: String): String = {
    command.replace("()", "o").replace("(al)","al")
  }
}
