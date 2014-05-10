/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 *
 * http://projecteuler.net/project/resources/007_c1bfcd3425fd13f6e9abcfad4a222e35/007_overview.pdf
 * http://jsfiddle.net/fosco/wSNkg/
 * http://jsfiddle.net/fosco/jDeuR/
 */

(function() {
    "use strict";

    /**
     * Returns 10 001st prime number
     *
     * @param {Number} primeNumber
     * @param {Number} offset
     * @param {Array} sieve
     * @returns {Number}
     */
    var findPrimeByNumber = function(primeNumber, offset, sieve) {
        sieve = sieve || [];
        offset = offset || 5;

        var sieveLength = sieve.length,
            start = sieveLength === 0 ? 2 : sieveLength;

        if (sieveLength !== 0) {
            --sieveLength;
        }

        var n = sieveLength + offset, k, l;

        for (k = start; k <= n; k++) {
            sieve[k] = 1;
        }

        for (k = 2; k * k <= n; k++) {
            if (sieve[k] === 1) {
                for (l = k * k; l <= n; l += k) {
                    sieve[l] = 0;
                }
            }
        }

        var index = 0,
            value = 0;

        for (k = 2; k <= sieve.length - 1; k++) {
            if (sieve[k] === 1) {
                ++index;
            }

            if (index === primeNumber) {
                value = k;
                break;
            }
        }

        if (value !== 0) {
            return value;
        }

        return findPrimeByNumber(primeNumber, offset, sieve);
    };

    console.log(findPrimeByNumber(10001, 100000, [])); //104743

    // Version 2, more optimal

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
     * Returns 10 001st prime number
     *
     * @param {number} primeNumber number of prime number
     * @returns {number}
     */
    var findPrimeByNumberVersion2 = function(primeNumber) {
        if (primeNumber === 1) {
            return 2;
        }

        //we know that 2 is prime
        var count = 1,
            value = 1;

        while (count < primeNumber) {
            value += 2;

            if (isPrime(value)) {
                ++count;
            }
        }

        return value;
    };

    console.log(findPrimeByNumberVersion2(10001)); //104743
}());
