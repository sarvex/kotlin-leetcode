internal class Solution {
  fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var i: Int = Arrays.binarySearch(letters, (target.code + 1).toChar())
    i = if (i < 0) -i - 1 else i
    return letters[i % letters.size]
  }
}
