var uniqueArray = function(items) {
    return items.filter(function(value, index, array) {
       var firstIndex = array.indexOf(value);
       return firstIndex == array.lastIndexOf(value) || firstIndex === index;
    });
};

console.log(uniqueArray([1, 2, 3, 1, 2, 4, 5, 0, 1, 4])) //output: [1, 2, 3, 4, 5, 0] 