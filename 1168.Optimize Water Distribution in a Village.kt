internal class Solution {
  private var p: IntArray

  fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray?>): Int {
    var n = n
    val nums: Array<IntArray> = Arrays.copyOf(pipes, pipes.size + n)
    for (i in 0 until n) {
      nums[pipes.size + i] = intArrayOf(0, i + 1, wells[i])
    }
    Arrays.sort(nums) { a, b -> a.get(2) - b.get(2) }
    p = IntArray(n + 1)
    for (i in 0..n) {
      p[i] = i
    }
    var ans = 0
    for (x in nums) {
      val a = x[0]
      val b = x[1]
      val c = x[2]
      val pa = find(a)
      val pb = find(b)
      if (pa != pb) {
        p[pa] = pb
        ans += c
        if (--n == 0) {
          return ans
        }
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
