package dynamicprogramming

//https://leetcode.com/problems/count-vowels-permutation
object CountVowelPermutation {

  def countVowelPermutation(n: Int): Int = {
    val dp = Array.ofDim[BigInt](n + 1, 26)

    def countPermutationWithRules(k: Int, ch: Char): BigInt = {
      if (dp(k)(ch - 'a') != null) {
        return dp(k)(ch - 'a')
      } else if (k == n) {
        return 1
      }
      dp(k)(ch - 'a') =
        ch match {
          case 'a' => countPermutationWithRules(k + 1, 'e')
          case 'e' => countPermutationWithRules(k + 1, 'a') + countPermutationWithRules(k + 1, 'i')
          case 'i' => countPermutationWithRules(k + 1, 'a') + countPermutationWithRules(k + 1, 'e') + countPermutationWithRules(k + 1, 'o') + countPermutationWithRules(k + 1, 'u')
          case 'o' => countPermutationWithRules(k + 1, 'i') + countPermutationWithRules(k + 1, 'u')
          case 'u' => countPermutationWithRules(k + 1, 'a')
        }
      dp(k)(ch - 'a')
    }

    List('a', 'e', 'i', 'o', 'u').map(countPermutationWithRules(1, _)).sum.mod(1000000007).intValue
  }

  def main(args: Array[String]): Unit = {
    println(countVowelPermutation(1))
    println(countVowelPermutation(2))
    println(countVowelPermutation(5))
    println(countVowelPermutation(10))
    println(countVowelPermutation(20))
    println(countVowelPermutation(2500))
  }
}
