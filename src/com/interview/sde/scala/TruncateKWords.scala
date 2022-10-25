//https://leetcode.com/problems/truncate-sentence/
object TruncateKWords {
  def truncateSentence(s: String, k: Int): String = {
  s.split(" ").take(k).mkString(" ")
  }
}
