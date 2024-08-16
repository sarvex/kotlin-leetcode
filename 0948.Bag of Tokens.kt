internal class Solution {
  fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    var power = power
    Arrays.sort(tokens)
    var ans = 0
    var score = 0
    var i = 0
    var j = tokens.size - 1
    while (i <= j) {
      if (power >= tokens[i]) {
        power -= tokens[i++]
        ans = max(ans, ++score)
      } else if (score > 0) {
        power += tokens[j--]
        --score
      } else {
        break
      }
    }
    return ans
  }
}
