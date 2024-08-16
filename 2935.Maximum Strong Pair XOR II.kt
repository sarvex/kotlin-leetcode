import java.util.*

internal class Trie {
  private val children: Array<Trie> = arrayOfNulls(2)
  private var cnt = 0

  fun insert(x: Int) {
    var node = this
    for (i in 20 downTo 0) {
      val v = x shr i and 1
      if (node.children[v] == null) {
        node.children[v] = Trie()
      }
      node = node.children[v]
      ++node.cnt
    }
  }

  fun search(x: Int): Int {
    var node = this
    var ans = 0
    for (i in 20 downTo 0) {
      val v = x shr i and 1
      if (node.children[v xor 1] != null && node.children[v xor 1].cnt > 0) {
        ans = ans or (1 shl i)
        node = node.children[v xor 1]
      } else {
        node = node.children[v]
      }
    }
    return ans
  }

  fun remove(x: Int) {
    var node = this
    for (i in 20 downTo 0) {
      val v = x shr i and 1
      node = node.children[v]
      --node.cnt
    }
  }
}

internal class Solution {
  fun maximumStrongPairXor(nums: IntArray): Int {
    Arrays.sort(nums)
    val tree = Trie()
    var ans = 0
    var i = 0
    for (y in nums) {
      tree.insert(y)
      while (y > nums[i] * 2) {
        tree.remove(nums[i++])
      }
      ans = max(ans, tree.search(y))
    }
    return ans
  }
}
