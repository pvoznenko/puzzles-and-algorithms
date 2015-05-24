/**
 * Complexity is O(n^2)
 * if list already sorted then complexity only O(n)
 *
 * @param {Array} array
 * @returns {Array}
 */
var bubbleSort = function(array) {
    var i, j,
        length = array.length;

    for (i = 0; i < length; i++) {
        for (j = 0; j < length - i; j++) {
            if (array[j] > array[j + 1]) {
                array[j] = [array[j + 1], array[j + 1] = array[j]][0];
            }
        }
    }

    return array;
};