var isBracketsValid = function(str) {
    var i, brackets,
        length = str.length;

    if (length % 2 !== 0) return false;

    for (i = 0; i < length; i++) {
        if (brackets < 0) return false;
        if (str[i] == '(') brackets++;
        if (str[i] == ')') brackets--;
    }

    return brackets == 0;
};

/**
 * ))(( => false
 * (()()) => true
 * ())( => false
 */