internal class Solution {
  fun candy(ratings: IntArray): Int {
    val n = ratings.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, 1)
    Arrays.fill(right, 1)
    for (i in 1 until n) {
      if (ratings[i] > ratings[i - 1]) {
        left[i] = left[i - 1] + 1
      }
    }
    for (i in n - 2 downTo 0) {
      if (ratings[i] > ratings[i + 1]) {
        right[i] = right[i + 1] + 1
      }
    }
    var ans = 0
    for (i in 0 until n) {
      ans += max(left[i], right[i])
    }
    return ans
  }
}
