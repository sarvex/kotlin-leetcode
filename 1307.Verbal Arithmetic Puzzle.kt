internal class Solution {
  private fun isAnyMapping(
    words: List<String>, row: Int, col: Int, bal: Int,
    letToDig: HashMap<Char, Int>, digToLet: CharArray, totalRows: Int, totalCols: Int
  ): Boolean {
    // If traversed all columns.
    if (col == totalCols) {
      return bal == 0
    }

    // At the end of a particular column.
    if (row == totalRows) {
      return (bal % 10 == 0
          && isAnyMapping(
        words, 0, col + 1, bal / 10, letToDig, digToLet, totalRows, totalCols
      ))
    }

    val w = words[row]

    // If the current string 'w' has no character in the ('col')th index.
    if (col >= w.length) {
      return isAnyMapping(words, row + 1, col, bal, letToDig, digToLet, totalRows, totalCols)
    }

    // Take the current character in the variable letter.
    val letter = w[w.length - 1 - col]

    // Create a variable 'sign' to check whether we have to add it or subtract it.
    val sign = if ((row < totalRows - 1)) 1 else -1

    // If we have a prior valid mapping, then use that mapping.
    // The second condition is for the leading zeros.
    if (letToDig.containsKey(letter)
      && (letToDig.get(letter) !== 0 || (letToDig.get(letter) === 0 && w.length == 1)
          || col != w.length - 1)
    ) {
      return isAnyMapping(
        words, row + 1, col, bal + sign * letToDig.get(letter), letToDig,
        digToLet, totalRows, totalCols
      )
    } else {
      // Choose a new mapping.
      for (i in 0..9) {
        // If 'i'th mapping is valid then select it.
        if (digToLet[i] == '-'
          && (i != 0 || (i == 0 && w.length == 1) || col != w.length - 1)
        ) {
          digToLet[i] = letter
          letToDig.put(letter, i)

          // Call the function again with the new mapping.
          if (isAnyMapping(
              words, row + 1, col, bal + sign * letToDig.get(letter),
              letToDig, digToLet, totalRows, totalCols
            )
          ) {
            return true
          }

          // Unselect the mapping.
          digToLet[i] = '-'
          letToDig.remove(letter)
        }
      }
    }

    // If nothing is correct then just return false.
    return false
  }

  fun isSolvable(wordsArr: Array<String?>, result: String?): Boolean {
    // Add the string 'result' in the list 'words'.
    val words: List<String> = ArrayList()
    for (word in wordsArr) {
      words.add(word)
    }
    words.add(result)

    val totalRows: Int = words.size()

    // Find the longest string in the list and set 'totalCols' with the size of that string.
    var totalCols = 0
    for (word in words) {
      if (totalCols < word.length) {
        totalCols = word.length
      }
    }

    // Create a HashMap for the letter to digit mapping.
    val letToDig: HashMap<Char, Int> = HashMap()

    // Create a char array for the digit to letter mapping.
    val digToLet = CharArray(10)
    for (i in 0..9) {
      digToLet[i] = '-'
    }

    return isAnyMapping(words, 0, 0, 0, letToDig, digToLet, totalRows, totalCols)
  }
}
