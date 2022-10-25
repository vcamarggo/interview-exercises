//https://leetcode.com/problems/count-items-matching-a-rule/
object CountMatchingRule {
  def countMatches(items: List[List[String]], ruleKey: String, ruleValue: String): Int = {
    val ruleIndex = ruleKey match {
      case "type" => 0
      case "color" => 1
      case "name" => 2
    }
    items.count(list => list(ruleIndex) == ruleValue)
  }
}
