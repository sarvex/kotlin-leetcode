internal class Solution {
  fun minOperations(nums: IntArray, x: Int): Int {
    var s = -x
    for (v in nums) {
      s += v
    }
    val vis: Map<Int, Int> = HashMap()
    vis.put(0, -1)
    var mx = -1
    var t = 0
    val n = nums.size
    for (i in 0 until n) {
      t += nums[i]
      vis.putIfAbsent(t, i)
      if (vis.containsKey(t - s)) {
        mx = Math.max(mx, i - vis[t - s])
      }
    }
    return if (mx == -1) -1 else n - mx
  }
}
