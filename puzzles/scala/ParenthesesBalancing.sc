// Parentheses Balancing
// Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char]
// not a String. For example, the function should return true for the following strings:
//   * (if (zero? x) max (/ 1 x))
//   * I told him (that it’s not (yet) done). (But he wasn’t listening)
// The function should return false for the following strings:
//    * :-)
//    * ())(
// The last example shows that it’s not enough to verify that a string contains the same number of opening and closing
// parentheses.

object ParenthesesBalancing {
  def balance(chars: List[Char]): Boolean = {
    def balanced(chars: List[Char], open: Int = 0): Boolean =
      if (chars.isEmpty) open == 0
      else if (chars.head == '(') balanced(chars.tail, open + 1)
      else if (chars.head == ')') open > 0 && balanced(chars.tail, open - 1)
      else balanced(chars.tail, open)

    balanced(chars)
  }                                               //> balance: (chars: List[Char])Boolean

  balance("(if (zero? x) max (/ 1 x))".toList)    //> res0: Boolean = true
  balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList)
                                                  //> res1: Boolean = true
  balance(":-)".toList)                           //> res2: Boolean = false
}