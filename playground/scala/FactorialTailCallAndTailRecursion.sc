// Factorial Tail Call and Tail Recursion
object FactorialTailCallAndTailRecursion {

  //Factorial Tail Call
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //]]> factorial: (n: Int)Int

  factorial(4)                                    //]]> res0: Int = 24

  // Tail Recursion
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)

    loop(1, n)
  }                                               //]]> factorial: (n: Int)Int

  factorial(4)                                    //]]> res0: Int = 24
}