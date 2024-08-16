internal class Solution {
  fun longestBeautifulSubstring(word: String): Int {
    val n = word.length
    val arr: List<Node> = ArrayList()
    run {
      var i = 0
      while (i < n) {
        var j = i
        while (j < n && word[j] == word[i]) {
          ++j
        }
        arr.add(Node(word[i], j - i))
        i = j
      }
    }
    var ans = 0
    for (i in 0 until arr.size() - 4) {
      val a = arr[i]
      val b = arr[i + 1]
      val c = arr[i + 2]
      val d = arr[i + 3]
      val e = arr[i + 4]
      if (a.c == 'a' && b.c == 'e' && c.c == 'i' && d.c == 'o' && e.c == 'u') {
        ans = max(ans, a.v + b.v + c.v + d.v + e.v)
      }
    }
    return ans
  }
}

internal open class Node(var c: Char, var v: Int) 
