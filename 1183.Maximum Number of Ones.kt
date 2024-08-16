internal class Solution {
  fun maximumNumberOfOnes(width: Int, height: Int, sideLength: Int, maxOnes: Int): Int {
    val x = sideLength
    val cnt = IntArray(x * x)
    for (i in 0 until width) {
      for (j in 0 until height) {
        val k: Int = (i % x) * x + (j % x)
        ++cnt[k]
      }
    }
    Arrays.sort(cnt)
    var ans = 0
    for (i in 0 until maxOnes) {
      ans += cnt[cnt.size - i - 1]
    }
    return ans
  }
}
