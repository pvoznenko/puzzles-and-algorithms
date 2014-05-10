/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *
 * Find the product abc.
 *
 * http://projecteuler.net/project/resources/009_5afd54de06d8664fadfde1889d8943ab/009_overview.pdf
 * http://jsfiddle.net/fosco/aHEnc/
 */

(function() {
    "use strict";

    /**
     * Product abc. BruteForcing way
     *
     * @returns {number}
     */
    var bruteForce = function() {
        var s = 1000,
            value = 0, a, b;

        for (a = 1; a <= s; a++) {
            for (b = a; b <= s; b++) {
                var c = Math.sqrt(a * a + b * b);

                if (a + b + c === s) {
                    value = a * b * c;
                    break;
                }
            }
            if (value !== 0) {
                break;
            }
        }

        return value;
    };

    console.time('Brute');
    console.log(bruteForce()); //31875000
    console.timeEnd('Brute'); // 9.975 ms


    /**
     * Product abc. Pythagorean triple way
     * http://en.wikipedia.org/wiki/Pythagorean_triple
     *
     * @returns {number}
     */
    var pythagoreanTriple = function() {
        var s = 1000,
            value = 0,
            a = 0,
            b = 0,
            c = 0, n, m;

        for (n = 1; n <= s; n++) {
            for (m = n; m <= s; m++) {
                a = m * m - n * n;
                b = 2 * m * n;
                c = m * m + n * n;

                if (a + b + c === s) {
                    value = a * b * c;
                    break;
                }
            }

            if (value !== 0) {
                break;
            }
        }

        return value;
    };

    console.time('M and N');
    console.log(pythagoreanTriple()); //31875000
    console.timeEnd('M and N'); // 0.190 ms
}());
