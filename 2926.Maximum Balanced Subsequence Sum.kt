import java.util.*

internal class BinaryIndexedTree(private val n: Int) {
  private val c = LongArray(n + 1)
  private val inf = 1L shl 60

  init {
    Arrays.fill(c, -inf)
  }

  fun update(x: Int, v: Long) {
    var x = x
    while (x <= n) {
      c[x] = max(c[x], v)
      x += x and -x
    }
  }

  fun query(x: Int): Long {
    var x = x
    var mx = -inf
    while (x > 0) {
      mx = max(mx, c[x])
      x -= x and -x
    }
    return mx
  }
}

internal class Solution {
  fun maxBalancedSubsequenceSum(nums: IntArray): Long {
    val n = nums.size
    val arr = IntArray(n)
    for (i in 0 until n) {
      arr[i] = nums[i] - i
    }
    Arrays.sort(arr)
    var m = 0
    for (i in 0 until n) {
      if (i == 0 || arr[i] != arr[i - 1]) {
        arr[m++] = arr[i]
      }
    }
    val tree = BinaryIndexedTree(m)
    for (i in 0 until n) {
      val j = search(arr, nums[i] - i, m) + 1
      val v: Long = max(tree.query(j), 0) + nums[i]
      tree.update(j, v.toInt())
    }
    return tree.query(m).toLong()
  }

  private fun search(nums: IntArray, x: Int, r: Int): Int {
    var r = r
    var l = 0
    while (l < r) {
      val mid = (l + r) shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
