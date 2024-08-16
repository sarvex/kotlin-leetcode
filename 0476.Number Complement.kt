internal class Solution {
  fun findComplement(num: Int): Int {
    return num xor ((1 shl (32 - Integer.numberOfLeadingZeros(num))) - 1)
  }
}
