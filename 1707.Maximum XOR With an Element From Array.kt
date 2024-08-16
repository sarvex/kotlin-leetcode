internal class Trie {
  private val children: Array<Trie> = arrayOfNulls(2)

  fun insert(x: Int) {
    var node = this
    for (i in 30 downTo 0) {
      val v = x shr i and 1
      if (node.children[v] == null) {
        node.children[v] = Trie()
      }
      node = node.children[v]
    }
  }

  fun search(x: Int): Int {
    var node = this
    var ans = 0
    for (i in 30 downTo 0) {
      val v = x shr i and 1
      if (node.children[v xor 1] != null) {
        ans = ans or (1 shl i)
        node = node.children[v xor 1]
      } else if (node.children[v] != null) {
        node = node.children[v]
      } else {
        return -1
      }
    }
    return ans
  }
}

internal class Solution {
  fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
    Arrays.sort(nums)
    val n = queries.size
    val idx: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> queries[i][1] - queries[j][1] }
    val ans = IntArray(n)
    val trie = Trie()
    var j = 0
    for (i in idx) {
      val x = queries[i][0]
      val m = queries[i][1]
      while (j < nums.size && nums[j] <= m) {
        trie.insert(nums[j++])
      }
      ans[i] = trie.search(x)
    }
    return ans
  }
}
