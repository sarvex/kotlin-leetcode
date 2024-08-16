internal class Solution {
  private var f: Array<Array<Int>>
  private var nums: IntArray
  private var ans: IntArray
  private var n = 0

  fun findPermutation(nums: IntArray): IntArray {
    n = nums.size
    ans = IntArray(n)
    this.nums = nums
    f = Array(1 shl n) { arrayOfNulls(n) }
    g(1, 0, 0)
    return ans
  }

  private fun dfs(mask: Int, pre: Int): Int {
    if (mask == (1 shl n) - 1) {
      return abs(pre - nums[0])
    }
    if (f[mask][pre] != null) {
      return f[mask][pre]
    }
    var res: Int = MAX_VALUE
    for (cur in 1 until n) {
      if ((mask shr cur and 1) == 0) {
        res = min(res, abs(pre - nums[cur]) + dfs(mask or (1 shl cur), cur))
      }
    }
    return res.also { f[mask][pre] = it }
  }

  private fun g(mask: Int, pre: Int, k: Int) {
    ans[k] = pre
    if (mask == (1 shl n) - 1) {
      return
    }
    val res = dfs(mask, pre)
    for (cur in 1 until n) {
      if ((mask shr cur and 1) == 0) {
        if (abs(pre - nums[cur]) + dfs(mask or (1 shl cur), cur) == res) {
          g(mask or (1 shl cur), cur, k + 1)
          break
        }
      }
    }
  }
}
