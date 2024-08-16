internal class Solution {
  private val ops = charArrayOf('+', '-', '*', '/')

  fun judgePoint24(cards: IntArray): Boolean {
    val nums: List<Double> = ArrayList()
    for (num in cards) {
      nums.add(num.toDouble())
    }
    return dfs(nums)
  }

  private fun dfs(nums: List<Double>): Boolean {
    val n: Int = nums.size()
    if (n == 1) {
      return Math.abs(nums[0] - 24) < 1e-6
    }
    var ok = false
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (i != j) {
          val nxt: List<Double> = ArrayList()
          for (k in 0 until n) {
            if (k != i && k != j) {
              nxt.add(nums[k])
            }
          }
          for (op in ops) {
            when (op) {
              '/' -> {
                if (nums[j] === 0) {
                  continue
                }
                nxt.add(nums[i] / nums[j])
              }

              '*' -> {
                nxt.add(nums[i] * nums[j])
              }

              '+' -> {
                nxt.add(nums[i] + nums[j])
              }

              '-' -> {
                nxt.add(nums[i] - nums[j])
              }
            }
            ok = ok or dfs(nxt)
            if (ok) {
              return true
            }
            nxt.remove(nxt.size() - 1)
          }
        }
      }
    }
    return ok
  }
}
