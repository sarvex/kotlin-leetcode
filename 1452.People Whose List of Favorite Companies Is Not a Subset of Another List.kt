internal class Solution {
  fun peopleIndexes(favoriteCompanies: List<List<String?>>): List<Int> {
    val n: Int = favoriteCompanies.size()
    val d: Map<String, Int> = HashMap()
    var idx = 0
    val nums: Array<Set<Int>> = arrayOfNulls(n)
    Arrays.setAll(nums) { i -> HashSet() }
    for (i in 0 until n) {
      val ss: Unit = favoriteCompanies[i]
      for (s in ss) {
        if (!d.containsKey(s)) {
          d.put(s, idx++)
        }
        nums[i].add(d[s])
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      var ok = true
      var j = 0
      while (j < n && ok) {
        if (i != j && nums[j].containsAll(nums[i])) {
          ok = false
        }
        ++j
      }
      if (ok) {
        ans.add(i)
      }
    }
    return ans
  }
}
