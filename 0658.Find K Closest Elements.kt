internal class Solution {
  fun findClosestElements(arr: IntArray?, k: Int, x: Int): List<Int?> {
    var ans: List<Int?> = Arrays.stream(arr)
      .boxed()
      .sorted { a, b ->
        val v: Int = abs(a - x) - abs(b - x)
        if (v == 0) a - b else v
      }
      .collect(Collectors.toList())
    ans = ans.subList(0, k)
    Collections.sort(ans)
    return ans
  }
}
