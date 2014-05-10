<?php
//A non-empty zero-indexed array A containing N different integers is given. We are looking for the longest possible sequence built from elements of A, A[B[0]], A[B[1]], ..., A[B[K]], satisfying the following conditions:
//
//   * The sequence must be decreasing; that is, A[B[0]] > A[B[1]] > ... > A[B[K]].
//   * For any two consecutive elements of the sequence, A[B[I]] and A[B[I+1]], all the elements of A between them must be smaller than them; that is, for any J = MIN(B[I], B[I+1]) + 1, ..., MAX(B[I], B[I+1]) − 1, we have A[J] < A[B[I+1]].
//
//
//Write a function:
//
//function sequence($A);
//
//that, given a zero-indexed array A containing N different integers, computes the maximum length of a sequence satisfying the above conditions.
//For example, for the following array A:
//
//  A[0]  =  9   A[1]  = 10   A[2]  =  2  A[3]  = -1   A[4]  =  3   A[5]  = -5  A[6]  =  0   A[7]  = -3   A[8]  =  1  A[9]  = 12   A[10] =  5   A[11] =  8  A[12] = -2   A[13] =  6   A[14] =  4
//
//the function should return 6.
//A sequence of length 6 satisfying the given conditions can be as follows:
//
//  A[9] = 12    A[1] = 10    A[4] =  3  A[8] =  1    A[6] =  0    A[7] = -3
//
//Assume that:
//
//   * the elements of A are all distinct;
//   * N is an integer within the range [1..100,000];
//   * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
//
//Complexity:
//
//   * expected worst-case time complexity is O(N);
//   * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//
//Elements of input arrays can be modified.

// not sure it solved, need to get to this puzzle later

$A = array();

$A[0]  =  9;   $A[1]  = 10;   $A[2]  =  2;
$A[3]  = -1;   $A[4]  =  3;   $A[5]  = -5;
$A[6]  =  0;   $A[7]  = -3;   $A[8]  =  1;
$A[9]  = 12;   $A[10] =  5;   $A[11] =  8;
$A[12] = -2;   $A[13] =  6;   $A[14] =  4;

function sequence ( $A ) {
    if (null == $A) {
        return 0;
    }

    $size = count($A);
    if ($size < 2) {
        return 0;
    }

    arsort($A);
    $count = array();
    $b = $A;
    foreach ($A as $aKey => $aVal) {
        unset($b[$aKey]);
        foreach ($b as $bKey => $bVal) {
            $min = min($aKey, $bKey) + 1;
            $max = max($aKey, $bKey) - 1;

            if ($min >= $max) {
                continue;
            }

            $flag = true;
            for ($j = $min; $j <= $max; $j++) {
                if ($A[$j] >= $bVal) {
                    $flag = false;
                    break;
                }
            }

            if ($flag) {
                $count[$aKey] = $aVal;
                $count[$bKey] = $bVal;
            }
        }
    }

    return count($count);
}