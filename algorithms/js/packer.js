/**
 * packer('aaabb') => '3a2b'
 * packer('abba') => '1a2b1a'
 */

var packer = function(items) {
    var i, data, tmp,
        counter = 0;

    if (items.length == 0) return '';

    tmp = items[0];

    for (i = 0; i < items.length; i++) {
        if (tmp == items[i]) {
            counter++;
        } else {
            data += counter + tmp;
            counter = 1;
            tmp = items[i];
        }
    }

    return data + counter + tmp;
};

console.log(packer('aaabb'));