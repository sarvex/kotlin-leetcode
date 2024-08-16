internal class Solution {
  fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    var mx = 0
    for (candy in candies) {
      mx = max(mx, candy)
    }
    val res: List<Boolean> = ArrayList()
    for (candy in candies) {
      res.add(candy + extraCandies >= mx)
    }
    return res
  }
}
