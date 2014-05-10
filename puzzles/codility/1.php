<?php
//A non-empty zero-indexed array A consisting of N integers is given. Each element of the array can be treated as a relative pointer to another element in the array: if A[K] = M then element A[K] points to element A[K+M].
//
//The array defines a sequence of jumps of a pawn as follows:
//
//initially, the pawn is located at element A[0];
//on each jump the pawn moves from its current element to the destination element pointed to by the current element; i.e. if the pawn stands on element A[K] then it jumps to the element pointed to by A[K];
//the pawn may jump forever or may jump out of the array.
//For example, consier the following array A.
//
//A[0] = 2    A[1] = 3    A[2] = 1
//A[3] = 1    A[4] = 3
//
//This array defines the following sequence of jumps of the pawn:
//
//- initially, the pawn is located at element A[0];
//- on the first jump, the pawn moves from A[0] to A[2] because 0 + A[0] = 2;
//- on the second jump, the pawn moves from A[2] to A[3] because 2 + A[2] = 3;
//- on the third jump, the pawn moves from A[3] to A[4] because 3 + A[3] = 4;
//- on the fourth jump, the pawn jumps out of the array.
//
//Write a function
//
//     function arrayJmp($A);
//
//that, given a non-empty zero-indexed array A consisting of N integers, returns the number of jumps after which the pawn will jump out of the array. The function should return −1 if the pawn will never jump out of the array.
//
//Assume that:
//
//- N is an integer within the range [1..100,000];
//- each element of array A is an integer within the range [−1,000,000..1,000,000].
//
//For example, given array A such that
//
//A[0] = 2    A[1] = 3    A[2] = 1
//A[3] = 1    A[4] = 3
//
//the function should return 4, as explained above. Given array A such that
//
//A[0] = 1    A[1] = 1    A[2] = -1
//A[3] = 1
//
//the function should return −1.
//
//Complexity:
//
//- expected worst-case time complexity is O(N);
//- expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//
//Elements of input arrays can be modified.


//$A = array(1, 1, 1, -2);
$A = array(2, 3, 1, 1, 3);
$i = 0;
$k = 0;
$return = -1;

if (min($A) > 0) {
    while(true) {
        $k = $i + $A[$i];

        if (!isset($A[$k])) {
            $return = $i;
            break;
        } else {
            $i = $k;
        }
    }
}

echo $return;