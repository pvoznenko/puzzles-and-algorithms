/**
 * http://jsfiddle.net/fosco/pdwq3/
 */

(function() {
    "use strict";

    /**
     * Returns prime factor tree
     *
     * @param {Number} number required
     * @param {Number} div
     * @param {Array} arr
     * @returns {Array}
     */
    var primeFactorTree = function(number, div, arr) {
        div = div || 2;
        arr = arr || [];

        if (number % div === 0) {
            number /= div;
            arr.push(div);

            if (number === 1) {
                return arr;
            }
        } else {
            ++div;
        }

        return primeFactorTree(number, div, arr);
    };

    console.log(primeFactorTree(24)); //[2, 2, 2, 3]
}());
