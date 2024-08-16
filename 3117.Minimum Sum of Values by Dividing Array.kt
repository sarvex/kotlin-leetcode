internal class Solution {
  private var nums: IntArray
  private var andValues: IntArray
  private val inf = 1 shl 29
  private val f: Map<Long, Int> = HashMap()

  fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
    this.nums = nums
    this.andValues = andValues
    val ans = dfs(0, 0, -1)
    return if (ans >= inf) -1 else ans
  }

  private fun dfs(i: Int, j: Int, a: Int): Int {
    var a = a
    if (nums.size - i < andValues.size - j) {
      return inf
    }
    if (j == andValues.size) {
      return if (i == nums.size) 0 else inf
    }
    a = a and nums[i]
    if (a < andValues[j]) {
      return inf
    }
    val key = i.toLong() shl 36 or (j.toLong() shl 32) or a.toLong()
    if (f.containsKey(key)) {
      return f[key]!!
    }

    var ans = dfs(i + 1, j, a)
    if (a == andValues[j]) {
      ans = min(ans, dfs(i + 1, j + 1, -1) + nums[i])
    }
    f.put(key, ans)
    return ans
  }
}
