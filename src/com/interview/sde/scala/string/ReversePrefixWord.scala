package string

//https://leetcode.com/problems/reverse-prefix-of-word/
object ReversePrefixWord {
  def reversePrefix(word: String, ch: Char): String = {
    val indexOfCh = word.indexOf(ch)
    if (indexOfCh != -1) {
      word.substring(0, indexOfCh + 1).reverse + word.substring(indexOfCh + 1)
    } else {
      word
    }
  }

  def main(args: Array[String]): Unit = {
    println(reversePrefix("abcdefd", 'd'))
  }
}
