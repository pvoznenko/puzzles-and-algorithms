// Functional Sets

object FunSets {
  /**
   *
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = (e => e == elem)
                                                  //> singletonSet: (elem: Int)Int => Boolean

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = (elem => s(elem) || t(elem))
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = (elem => s(elem) && t(elem))
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = (elem => s(elem) && !t(elem))
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000                                //> bound  : Int = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (!p(a) && s(a)) false
      else iter(a + 1)
    }

    iter(-bound)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))
                                                  //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = {
    def _map(i: Int, currentSet: Set): Set =
      if (i > bound) currentSet
      else if (contains(s, i)) _map(i + 1, union(currentSet, singletonSet(f(i))))
      else _map(i + 1, currentSet)

    _map(-bound, (_ => false))
  }                                               //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: Int => Boolean)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: Int => Boolean)Unit

  val s1 = singletonSet(1)                        //> s1  : Int => Boolean = <function1>
  val s2 = singletonSet(2)                        //> s2  : Int => Boolean = <function1>
  val s3 = singletonSet(3)                        //> s3  : Int => Boolean = <function1>

  contains(s1, 1)                                 //> res0: Boolean = true

  val s = union(s1, s2)                           //> s  : Int => Boolean = <function1>
  printSet(s)                                     //> {1,2}
  contains(s, 1)                                  //> res1: Boolean = true
  contains(s, 2)                                  //> res2: Boolean = true
  contains(s, 3)                                  //> res3: Boolean = false

  val is = intersect(s1, s1)                      //> is  : Int => Boolean = <function1>
  printSet(is)                                    //> {1}
  contains(is, 1)                                 //> res4: Boolean = true
  contains(is, 2)                                 //> res5: Boolean = false

  val diff1 = diff(s1, s1)                        //> diff1  : Int => Boolean = <function1>
  printSet(diff1)                                 //> {}
  contains(diff1, 1)                              //> res6: Boolean = false

  val diff2 = diff(s1, s2)                        //> diff2  : Int => Boolean = <function1>
  printSet(diff2)                                 //> {1}
  contains(diff2, 1)                              //> res7: Boolean = true

  val fs = filter(s1, s1)                         //> fs  : Int => Boolean = <function1>
  printSet(fs)                                    //> {1}
  contains(fs, 1)                                 //> res8: Boolean = true
  contains(fs, 2)                                 //> res9: Boolean = false

  val us = union(union(s1, s2), s3)               //> us  : Int => Boolean = <function1>
  printSet(us)                                    //> {1,2,3}
  forall(us, (x => x < 1000))                     //> res10: Boolean = true
  forall(us, (x => x < 0))                        //> res11: Boolean = false

  exists(us, (x => x == 3))                       //> res12: Boolean = true
  exists(us, (x => x == 4))                       //> res13: Boolean = false

  val m = map(us, x => x * 2)                     //> m  : Int => Boolean = <function1>
  val diffAfterMap = diff(s, m)                   //> diffAfterMap  : Int => Boolean = <function1>
  printSet(diffAfterMap)                          //> {1}

  contains(diffAfterMap, 1)                       //> res14: Boolean = true
}