/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * http://projecteuler.net/project/resources/003_96c8248cc19fc7807cdacab7c7e4b3b2/003_overview.pdf
 * http://jsfiddle.net/fosco/pLe76/
 */

(function () {
    "use strict";

    /**
     * Largest prime factor of the number
     *
     * @param {Number} number
     * @returns {Number}
     */
    var largestPrimeFactor = function(number) {

        /**
         * Loop
         *
         * @param {Number} number
         * @param {Number} i iterator
         * @returns {Number}
         */
        var itr = function(number, i) {
            if (i > number) {
                return i;
            }

            if (number % i === 0) {
                return itr(number / i, i);
            }

            return itr(number, i + 1);
        };

        return itr(number, 2);
    };

    console.log(largestPrimeFactor(600851475143)); //6857
}());