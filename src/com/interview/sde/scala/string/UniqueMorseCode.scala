package string

//https://leetcode.com/problems/unique-morse-code-words
object UniqueMorseCode {
  val morseCode: Seq[String] = Vector(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")

  def main(args: Array[String]): Unit = {
    print(uniqueMorseRepresentations(Array("gin","zen","gig","msg")))
  }

  def uniqueMorseRepresentations(words: Array[String]): Int = {
    words.map(_.map(c => morseCode(c - 'a')).mkString).distinct.length
  }
}
