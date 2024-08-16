internal class Solution {
  private val nums: List<Int> = ArrayList()

  fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val vowels: Set<Char> = Set.of('a', 'e', 'i', 'o', 'u')
    for (i in words.indices) {
      val a = words[i][0]
      val b = words[i][words[i].length - 1]
      if (vowels.contains(a) && vowels.contains(b)) {
        nums.add(i)
      }
    }
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val l = queries[i][0]
      val r = queries[i][1]
      ans[i] = search(r + 1) - search(l)
    }
    return ans
  }

  private fun search(x: Int): Int {
    var l = 0
    var r: Int = nums.size()
    while (l < r) {
      val mid = (l + r) shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
