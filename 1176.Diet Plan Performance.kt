internal class Solution {
  fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
    val n = calories.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + calories[i]
    }
    var ans = 0
    for (i in 0 until n - k + 1) {
      val t = s[i + k] - s[i]
      if (t < lower) {
        --ans
      } else if (t > upper) {
        ++ans
      }
    }
    return ans
  }
}
