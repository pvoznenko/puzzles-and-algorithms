/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * http://projecteuler.net/project/resources/004_c20e2a33704cd30afb5dbe9530e30a00/004_overview.pdf
 * http://jsfiddle.net/fosco/aQBy3/
 */

(function () {
    "use strict";

    /**
     * Largest palindrome made from the product of two 3-digit numbers
     *
     * @returns {number}
     */
    var largestPalindrome = function() {
        var palindrome = 0,
            a = 1000;

        while (--a >= 100) {
            var b = a + 1;
            while (--b >= 100) {
                var result = a * b;

                if (result <= palindrome) {
                    break;
                }

                var str = result.toString(),
                    rev = str.split('').reverse().join('');

                if (str != rev) {
                    continue;
                }

                palindrome = result;
            }
        }

        return palindrome;
    };

    console.log(largestPalindrome()); //906609
}());