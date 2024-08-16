internal class Solution {
  fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
    if (numOnes >= k) {
      return k
    }
    if (numZeros >= k - numOnes) {
      return numOnes
    }
    return numOnes - (k - numOnes - numZeros)
  }
}
