internal class Solution {
  fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val cnt: Map<String, Int> = HashMap()
    for (s in s1.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      cnt.merge(s, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    for (s in s2.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      cnt.merge(s, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val ans: List<String> = ArrayList()
    for (e in cnt.entrySet()) {
      if (e.getValue() === 1) {
        ans.add(e.getKey())
      }
    }
    return ans.toArray(arrayOfNulls<String>(0))
  }
}
