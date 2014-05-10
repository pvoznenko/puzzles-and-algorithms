// Pascal’s Triangle
// The following pattern of numbers is called Pascal’s triangle.
//          1
//         1 1
//        1 2 1
//       1 3 3 1
//      1 4 6 4 1
//         ...
// The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers
// above it. Write a function that computes the elements of Pascal’s triangle by means of a recursive process.

object PascalsTriangle {
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)  //> pascal: (c: Int, r: Int)Int

  println("Pascal's Triangle")                    //> Pascal's Triangle
  for (row <- 0 to 4) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println()
  }                                               //> 1
                                                  //| 1 1
                                                  //| 1 2 1
                                                  //| 1 3 3 1
                                                  //| 1 4 6 4 1
}