internal class Solution {
  fun distributeCandies(candies: Int, num_people: Int): IntArray {
    var candies = candies
    val ans = IntArray(num_people)
    var i = 0
    while (candies > 0) {
      ans[i % num_people] += min(candies, i + 1)
      candies -= min(candies, i + 1)
      ++i
    }
    return ans
  }
}
