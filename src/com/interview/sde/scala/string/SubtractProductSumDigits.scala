package string

//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
object SubtractProductSumDigits {
  def subtractProductAndSum(n: Int): Int = {
    //Option 1
    val nString = n.toString.map(_.asDigit)
    nString.product - nString.sum

    //Option 2
    //    val (sum, prod) = n.toString.map(_.asDigit)
    //      .foldLeft((0, 1))((sumProduct, current) =>
    //        (sumProduct._1 + current, sumProduct._2 * current)
    //      )
    //    prod - sum
  }


  def main(args: Array[String]): Unit = {
    println(subtractProductAndSum(234))
  }
}
