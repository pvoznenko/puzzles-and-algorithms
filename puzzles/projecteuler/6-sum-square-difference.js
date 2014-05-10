/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * http://projecteuler.net/project/resources/006_8ff3854d43f923db0942e2ce73b1be0b/006_overview.pdf
 * http://jsfiddle.net/fosco/pWZy7/
 */

(function() {
    "use strict";

    var n = 100,
        //Sums of the First n Natural Numbers
        sumOfNaturalNumbers = (n * (n + 1)) / 2,
        //Sum of the Squares of the First n Natural Numbers
        sumOfSquareRootNumbers = (n * (n + 1) * (2 * n + 1)) / 6,
        squareRootOfSumOfNaturalNumbers = Math.pow(sumOfNaturalNumbers, 2),
        difference = squareRootOfSumOfNaturalNumbers - sumOfSquareRootNumbers;

    console.log(difference); //25164150
}());
