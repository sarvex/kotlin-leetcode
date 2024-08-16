internal class Solution {
  private val nums: List<Int> = ArrayList()

  fun minimumDeletions(word: String, k: Int): Int {
    val freq = IntArray(26)
    val n = word.length
    for (i in 0 until n) {
      ++freq[word[i].code - 'a'.code]
    }
    for (v in freq) {
      if (v > 0) {
        nums.add(v)
      }
    }
    var ans = n
    for (i in 0..n) {
      ans = min(ans, f(i, k))
    }
    return ans
  }

  private fun f(v: Int, k: Int): Int {
    var ans = 0
    for (x in nums) {
      if (x < v) {
        ans += x
      } else if (x > v + k) {
        ans += x - v - k
      }
    }
    return ans
  }
}
