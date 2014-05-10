/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * http://projecteuler.net/project/resources/001_c619a145e9d327a5c4c84649bec9981b/001_overview.pdf
 * http://jsfiddle.net/fosco/ZJrtP/
 */

(function() {
    "use strict";

    /**
     * Arithmetic progression 1 + 2 + 3 + … + n = (n * (n + 1)) / 2
     *
     * @param {Number} n
     * @returns {Number}
     */
    var sumDivisibleBy = function(n) {
        var p = parseInt(999 / n, 10);
        return parseInt(n * (p * (p + 1)) / 2, 10);
    };

    console.log(sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15)); // 233168
}());
