/**
 * http://jsfiddle.net/fosco/efDSt/
 */

(function() {
    "use strict";

    /**
     * Returns Sieve of Eratosthenes for specified number
     *
     * @param {Number} n
     * @returns {Array}
     */
    var sieve = function(n) {
        var s = [], k, l;

        s[1] = 0;

        for (k = 2; k <= n; k++) {
            s[k] = 1;
        }

        for (k = 2; k * k <= n; k++) {
            if (s[k] === 1) {
                for (l = k * k; l <= n; l += k) {
                    s[l] = 0;
                }
            }
        }

        return s;
    };
}());
