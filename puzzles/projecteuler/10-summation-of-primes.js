/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * http://projecteuler.net/project/resources/010_7c4950764b52402fe1d29323af4e6c6f/010_overview.pdf
 * http://jsfiddle.net/fosco/qEUSR/
 */

(function() {
    "use strict";

    /**
     * Returns true if specified number is prime
     * @param {Number} n
     * @returns {boolean}
     */
    var isPrime = function(n) {
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

    /**
     * Sum of all the primes below two million
     *
     * @param {Number} number
     * @returns {Number}
     */
    var sumOfPrimesBelow = function(number) {
        var value = 1,
            sum = 2;

        while (true) {
            value += 2;

            if (!isPrime(value)) {
                continue;
            }

            if (value > number) {
                break;
            }

            sum += value;
        }

        return sum;
    };

    console.time('sumOfPrimesBelow');
    console.log(sumOfPrimesBelow(2000000)); //142913828922
    console.timeEnd('sumOfPrimesBelow'); //596.794ms

    // Version 2

    /**
     * Sum of all the primes below two million
     *
     * @param {Number} n
     * @returns {Number}
     */
    var sumOfPrimesBelowWithSieve = function(n) {
        var sieve = [], k, l;

        for (k = 2; k <= n; k++) {
            sieve[k] = 1;
        }

        for (k = 2; k * k <= n; k++) {
            if (sieve[k] === 1) {
                for (l = k * k; l <= n; l += k) {
                    sieve[l] = 0;
                }
            }
        }

        var sum = 0;

        sieve.forEach(function(val, key){
            if (val === 1) {
                sum += key;
            }
        });

        return sum;
    };

    console.time('sumOfPrimesBelowWithSieve');
    console.log(sumOfPrimesBelowWithSieve(2000000)); //104743
    console.timeEnd('sumOfPrimesBelowWithSieve'); //440.432ms
}());
