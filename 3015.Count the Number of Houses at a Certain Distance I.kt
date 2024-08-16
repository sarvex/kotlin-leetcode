internal class Solution {
  fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
    var x = x
    var y = y
    val ans = IntArray(n)
    x--
    y--
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        val a: Int = j - i
        val b: Int = abs(i - x) + 1 + abs(j - y)
        val c: Int = abs(i - y) + 1 + abs(j - x)
        ans[min(a, min(b, c)) - 1] += 2
      }
    }
    return ans
  }
}
