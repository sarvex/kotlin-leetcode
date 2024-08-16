internal class Solution {
  fun countOfPairs(n: Int, x: Int, y: Int): LongArray {
    var x = x
    var y = y
    --x
    --y
    if (x > y) {
      val temp = x
      x = y
      y = temp
    }
    val diff = LongArray(n)
    for (i in 0 until n) {
      diff[0] += (1 + 1).toLong()
      ++diff[min(abs(i - x), abs(i - y) + 1)]
      ++diff[min(abs(i - y), abs(i - x) + 1)]
      --diff[min(abs(i - 0), abs(i - y) + 1 + abs(x - 0))]
      --diff[min(abs(i - (n - 1)), abs(i - x) + 1 + abs(y - (n - 1)))]
      --diff[max(x - i, 0) + max(i - y, 0) + ((y - x) + 0) / 2]
      --diff[max(x - i, 0) + max(i - y, 0) + ((y - x) + 1) / 2]
    }
    var i = 0
    while (i + 1 < n) {
      diff[i + 1] += diff[i]
      ++i
    }
    return diff
  }
}
