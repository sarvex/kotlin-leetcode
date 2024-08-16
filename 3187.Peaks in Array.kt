internal class BinaryIndexedTree(private val n: Int) {
  private val c = IntArray(n + 1)

  fun update(x: Int, delta: Int) {
    var x = x
    while (x <= n) {
      c[x] += delta
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  private var tree: BinaryIndexedTree? = null
  private var nums: IntArray

  fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): List<Int> {
    val n = nums.size
    this.nums = nums
    tree = BinaryIndexedTree(n - 1)
    for (i in 1 until n - 1) {
      update(i, 1)
    }
    val ans: List<Int> = ArrayList()
    for (q in queries) {
      if (q[0] == 1) {
        val l = q[1] + 1
        val r = q[2] - 1
        ans.add(if (l > r) 0 else tree!!.query(r) - tree!!.query(l - 1))
      } else {
        val idx = q[1]
        val `val` = q[2]
        for (i in idx - 1..(idx + 1)) {
          update(i, -1)
        }
        nums[idx] = `val`
        for (i in idx - 1..(idx + 1)) {
          update(i, 1)
        }
      }
    }
    return ans
  }

  private fun update(i: Int, `val`: Int) {
    if (i <= 0 || i >= nums.size - 1) {
      return
    }
    if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
      tree!!.update(i, `val`)
    }
  }
}
