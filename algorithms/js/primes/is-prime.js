/**
 * http://jsfiddle.net/fosco/PPSZy/
 * http://jsfiddle.net/fosco/49xhN/
 */

(function() {
    "use strict";

    /**
     * Returns true if specified number is prime
     * @param {Number} n
     * @returns {boolean}
     */
    var isPrimeSimple = function(n) {
        if (n === 1) {
            return false;
        }

        var i;

        for (i = 2; i * i <= n; i++) {
            if (n % i === 0) {
                return false;
            }
        }

        return true;
    };

    /**
     * Returns true if specified number is prime
     * @param {Number} n
     * @returns {boolean}
     */
    var isPrimeAdvanced = function(n) {
        if (n === 1) {
            return false;
        }

        if (n < 4) {
            //2 and 3 are prime
            return true;
        }

        if (n % 2 === 0) {
            return false;
        }

        if (n < 9) {
            //we have already excluded 4,6 and 8.
            return true;
        }

        if (n % 3 === 0) {
            return false;
        }

        // n rounded to the greatest integer r so that r*r<=n
        var r = Math.floor(Math.sqrt(n)),
            f = 5;

        while (f <= r) {
            if (n % f === 0) {
                return false;
            }

            if (n % (f + 2) === 0) {
                return false;
            }

            f += 6;
        }

        return true;
    };
}());