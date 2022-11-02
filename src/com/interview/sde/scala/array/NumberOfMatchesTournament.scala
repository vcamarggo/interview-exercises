package array

import scala.annotation.tailrec
//https://leetcode.com/problems/count-of-matches-in-tournament/
object NumberOfMatchesTournament {
  @tailrec
  def numberOfMatches(n: Int, matches: Int = 0): Int = {
    n match {
      case 1 => matches
      case x if x % 2 == 0 => numberOfMatches(n / 2, n / 2 + matches)
      case x if x % 2 != 0 => numberOfMatches((n - 1) / 2, (n - 1) / 2 + 1 + matches)
    }
  }
}
