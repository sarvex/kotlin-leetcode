/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 * public InfiniteStream(int[] bits);
 * public int next();
 * }
 */
internal class Solution {
  fun findPattern(infiniteStream: InfiniteStream, pattern: IntArray): Int {
    var a: Long = 0
    var b: Long = 0
    val m = pattern.size
    val half = m shr 1
    val mask1 = (1L shl half) - 1
    val mask2 = (1L shl (m - half)) - 1
    for (i in 0 until half) {
      a = a or (pattern[i].toLong() shl (half - 1 - i))
    }
    for (i in half until m) {
      b = b or (pattern[i].toLong() shl (m - 1 - i))
    }
    var x: Long = 0
    var y: Long = 0
    var i = 1
    while (true) {
      var v: Int = infiniteStream.next()
      y = y shl 1 or v.toLong()
      v = ((y shr (m - half)) and 1L).toInt()
      y = y and mask2
      x = x shl 1 or v.toLong()
      x = x and mask1
      if (i >= m && a == x && b == y) {
        return i - m
      }
      ++i
    }
  }
}
