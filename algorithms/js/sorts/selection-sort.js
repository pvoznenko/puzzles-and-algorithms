/**
 * Complexity is O(n^2)
 *
 * @param {Array} array
 * @returns {Array}
 */
var selectionSort = function(array) {
    var i, j, min,
        length = array.length;

    for (i = 0; i < length; i++) {
        min = i;

        for (j = i + 1; j < length; j++) {
            if (array[j] < array[min]) {
                min = j
            }

            array[i] = [array[min], array[min] = array[i]][0];
        }
    }

    return array;
};