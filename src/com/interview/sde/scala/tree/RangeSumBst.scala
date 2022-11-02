package tree

//https://leetcode.com/problems/range-sum-of-bst
object RangeSumBst {

  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    def isValueInRange = {
      root.value >= low && root.value <= high
    }

    root match {
        case null => 0
        case root: TreeNode if isValueInRange => root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        case root: TreeNode if root.value < low => rangeSumBST(root.right, low, high)
        case root: TreeNode if root.value > high => rangeSumBST(root.left, low, high)
      }
  }
}
