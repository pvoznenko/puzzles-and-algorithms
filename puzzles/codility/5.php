<?php
//A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.
//
//A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
//
//Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
//For example, consider the following array A consisting of N = 7 elements:
//
//A[0] = -7   A[1] =  1   A[2] = 5A[3] =  2   A[4] = -4   A[5] = 3A[6] =  0
//
//P = 3 is an equilibrium index of this array, because:
//
//   * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
//
//P = 6 is also an equilibrium index, because:
//
//   * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] = 0
//
//and there are no elements with indices greater than 6.
//P = 7 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
//Write a function:
//
//     function equi($A);
//
//that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
//Assume that:
//
//   * N is an integer within the range [0..10,000,000];
//   * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
//
//For example, given array A such that
//
//A[0] = -7   A[1] =  1   A[2] = 5A[3] =  2   A[4] = -4   A[5] = 3A[6] =  0
//
//the function may return 3 or 6, as explained above.
//Complexity:
//
//   * expected worst-case time complexity is O( N );
//   * expected worst-case space complexity is O( N ), beyond input storage (not counting the storage required for input arguments).
//
//Elements of input arrays can be modified.

// not sure it solved, need to get to this puzzle later

function equi($A)
{
    if (null == $A) {
        return -1;
    }

    if (0 == count($A)) {
        return -1;
    }

    $runningSum = 0;
    $runningSums = array();

    foreach ($A as $key => $val) {
        $runningSum += $val;
        $runningSums[$key] = $runningSum;
    }

    foreach ($A as $key => $val) {
        $left = $runningSums[$key] - $val;
        $right = $runningSum - $runningSums[$key];

        if ($left == $right) {
            return $key;
        }
    }

    return -1;
}