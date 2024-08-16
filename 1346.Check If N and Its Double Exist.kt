internal class Solution {
  fun checkIfExist(arr: IntArray): Boolean {
    val s: Set<Int> = HashSet()
    for (x in arr) {
      if (s.contains(x * 2) || ((x % 2 == 0 && s.contains(x / 2)))) {
        return true
      }
      s.add(x)
    }
    return false
  }
}
