package tree

//https://leetcode.com/problems/evaluate-boolean-binary-tree/
object EvaluateBinaryTree {
  def evaluateTree(root: TreeNode): Boolean = {
    root.value match {
      case 0 => false
      case 1 => true
      case 2 => evaluateTree(root.left) || evaluateTree(root.right)
      case 3 => evaluateTree(root.left) && evaluateTree(root.right)
    }
  }
}
