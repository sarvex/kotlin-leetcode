internal class Solution {
  fun numberOfGoodPartitions(nums: IntArray): Int {
    val last: Map<Int, Int> = HashMap()
    val n = nums.size
    for (i in 0 until n) {
      last.put(nums[i], i)
    }
    val mod = 1e9.toInt() + 7
    var j = -1
    var k = 0
    for (i in 0 until n) {
      j = Math.max(j, last[nums[i]]!!)
      k += if (i == j) 1 else 0
    }
    return qpow(2, k - 1, mod)
  }

  private fun qpow(a: Long, n: Int, mod: Int): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if ((n and 1) == 1) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans.toInt()
  }
}
