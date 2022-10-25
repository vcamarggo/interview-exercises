object IsPangram {
  def checkIfPangram(sentence: String): Boolean = {
    sentence.distinct.length == 26
  }
}
