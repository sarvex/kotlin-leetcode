internal class Solution {
  fun maxNumber(n: Long): Long {
    return (1L shl (63 - java.lang.Long.numberOfLeadingZeros(n))) - 1
  }
}
