var fibonacciSum = function(n) {
    return n < 2 ? n : fibonacciSum(n - 1) + fibonacciSum(n - 2);
};

var fibonacciSumMemoization = (function() {
    var memo = {};

    return function(n) {
        if (memo[n]) {
            return memo[n];
        }

        memo[n] = (n < 2) ? n : fibonacciSumMemoization(n - 1) + fibonacciSumMemoization(n - 2);

        return memo[n];
    };
})();