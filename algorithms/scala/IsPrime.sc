// Is Prime
object IsPrime {
  def isPrime (n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean

  isPrime(5)                                      //> res1: Boolean = true
  isPrime(6)                                      //> res2: Boolean = false

  val n = 7                                       //> n  : Int = 7

  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))                   //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))

  /**
   * ﬁnd the second prime number between 1000 and 10000:
   */

  ((1000 to 10000).toStream filter isPrime)(1)   //> res0: Int = 1013

  /**
   * recursive alternative
   */

  def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2)
                                                  //> secondPrime: (from: Int, to: Int)Int
  def nthPrime(from: Int, to: Int, n: Int): Int =
    if (from >= to) throw new Error("no prime")
    else if (isPrime(from))
      if (n == 1) from else nthPrime(from + 1, to, n - 1)
    else nthPrime(from + 1, to, n)                //> nthPrime: (from: Int, to: Int, n: Int)Int

  secondPrime(1000, 10000)                        //> res1: Int = 1013
}