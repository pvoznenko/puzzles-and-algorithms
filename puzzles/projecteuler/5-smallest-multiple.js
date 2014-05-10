/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * http://projecteuler.net/project/resources/005_f10c761be4eb8fc6ddd71c48b18c95fe/005_overview.pdf
 * http://jsfiddle.net/fosco/zkewE/
 */

(function () {
    "use strict";

    /**
     * For number 24 primes are: 2 * 2 * 2 * 3 and function will return ['2' : 3, '3' : 1]
     *
     * @param {Number} number
     * @param {Number} div
     * @param {Array} arr
     * @returns {Array}
     */
    var primeFactor = function(number, div, arr) {
        div = div || 2;
        arr = arr || [];

        if (number % div === 0) {
            number /= div;
            var divStr = div.toString();

            if (arr[divStr] === undefined) {
                arr[divStr] = 1;
            } else {
                arr[divStr] += 1;
            }

            if (number === 1) {
                return arr;
            }
        } else {
            div += 1;
        }

        return primeFactor(number, div, arr);
    };

    var set = [], i;

    /**
     * Set specified key and val to set
     *
     * @param {Number} val
     * @param {Number} key
     */
    var setValInSet = function(val, key) {
        if (set[key] === undefined || set[key] < val) {
            set[key] = val;
        }
    };

    for (i = 2; i <= 20; (i += 1)) {
        var primeArray = primeFactor(i);

        primeArray.forEach(setValInSet);
    }

    var value = 1;

    set.forEach(function(val, key) {
        value *= Math.pow(parseInt(key, 10), val);
    });

    console.log(value); //232792560
}());