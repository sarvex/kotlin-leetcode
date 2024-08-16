import java.util.*

internal class Solution {
  private var p: IntArray
  private var size: IntArray

  fun validSubarraySize(nums: IntArray, threshold: Int): Int {
    val n = nums.size
    p = IntArray(n)
    size = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      arr[i][0] = nums[i]
      arr[i][1] = i
    }
    Arrays.sort(arr) { a, b -> b[0] - a[0] }
    val vis = BooleanArray(n)
    for (e in arr) {
      val v = e[0]
      val i = e[1]
      if (i > 0 && vis[i - 1]) {
        merge(i, i - 1)
      }
      if (i < n - 1 && vis[i + 1]) {
        merge(i, i + 1)
      }
      if (v > threshold / size[find(i)]) {
        return size[find(i)]
      }
      vis[i] = true
    }
    return -1
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  private fun merge(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return
    }
    p[pa] = pb
    size[pb] += size[pa]
  }
}
