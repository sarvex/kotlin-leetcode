internal class Solution {
  fun canReorderDoubled(arr: IntArray): Boolean {
    val freq: Map<Int, Int> = HashMap()
    for (v in arr) {
      freq.put(v, freq.getOrDefault(v, 0) + 1)
    }
    if ((freq.getOrDefault(0, 0) and 1) !== 0) {
      return false
    }
    val keys: List<Int> = ArrayList(freq.keySet())
    keys.sort(Comparator.comparingInt(Math::abs))
    for (k in keys) {
      if (freq.getOrDefault(k shl 1, 0) < freq[k]!!) {
        return false
      }
      freq.put(k shl 1, freq.getOrDefault(k shl 1, 0) - freq[k]!!)
    }
    return true
  }
}
