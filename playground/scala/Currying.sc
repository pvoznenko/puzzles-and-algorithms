// Currying

object currying {
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int

  sumInts(2, 4)                                   //> res0: Int = 9
  sumCubes(2, 3)                                  //> res1: Int = 35

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b) //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 7)                       //> res2: Int = 6350400

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int

  fact(5)                                         //> res3: Int = 120
}