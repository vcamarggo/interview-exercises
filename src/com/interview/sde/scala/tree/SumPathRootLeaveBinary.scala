package tree

//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
object SumPathRootLeaveBinary {
  def sumRootToLeaf(root: TreeNode, number: String = ""): Int = {
    def isLeafNode = {
      root.right == null && root.left == null
    }

    if (root == null)
      return 0

    val newNumber = number + root.value.toString
    if (isLeafNode)
      BigInt(newNumber, 2).toString(10).toInt
    else
      sumRootToLeaf(root.left, newNumber) + sumRootToLeaf(root.right, newNumber)
  }
}
