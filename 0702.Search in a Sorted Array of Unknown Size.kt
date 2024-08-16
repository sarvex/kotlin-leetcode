/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
internal class Solution {
  fun search(reader: ArrayReader, target: Int): Int {
    var r = 1
    while (reader.get(r) < target) {
      r = r shl 1
    }
    var l = r shr 1
    while (l < r) {
      val mid = (l + r) shr 1
      if (reader.get(mid) >= target) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return if (reader.get(l) === target) l else -1
  }
}
