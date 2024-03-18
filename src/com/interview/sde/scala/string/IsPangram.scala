package string

object IsPangram {
  def checkIfPangram(sentence: String): Boolean = {
    sentence.toSeq.distinct.length == 26
  }
}
