<?php
//A central sphere of radius R is the set of all points (x, y, z) in 3D space that satisfy the following equation:
//
//     x^2 + y^2 + z^2 = R^2
//
//We say that a set of central spheres covers a set points if each of the points belongs to one of the spheres.
//
//Write a function:
//
//class Point3D {
//    var $x = 0;
//    var $y = 0;
//    var $z = 0;
//}
//
//function central_sphere_coverage_size($A);
//
//that, given an array describing of a set of points in 3D space, returns the minimum number of central spheres required to cover them.
//
//For example, given the following array:
//
// A[0].x =  0  A[0].y =  5  A[0].z =  4
// A[1].x =  0  A[1].y =  0  A[1].z = -3
// A[2].x = -2  A[2].y =  1  A[2].z = -6
// A[3].x =  1  A[3].y = -2  A[3].z =  2
// A[4].x =  1  A[4].y =  1  A[4].z =  1
// A[5].x =  4  A[5].y = -4  A[5].z =  3
//
//the function should return 3, because three central spheres are required to cover these points:
//
//- a central sphere of radius sqrt(3) covers point number 4,
//- a central sphere of radius 3 covers points numbers 1 and 3,
//- a central sphere of radius sqrt(41) covers points numbers 0, 2 and 5.
//
//It is impossible to cover these points with fewer central spheres.
//
//Assume that:
//
//- N is an integer within the range [0..100,000];
//- the coordinates of each point in array A are integers within the range [−10,000..10,000].
//
//Complexity:
//
//- expected worst-case time complexity is O(N * log( N ));
//- expected worst-case space complexity is O( N ), beyond input storage (not counting the storage required for input arguments).
//
//Elements of input arrays can be modified.

// Probably I could not solve it

//$A = array();
//$A[0] = new Point3D();
//$A[0]->x = 1;
//$A[1]->x = 0;
//$A[2]->x = 3;
//
//$maxX = 0;
//$maxY = 0;
//$maxZ = 0;
//
//foreach ($A as $key => $val) {
//    $valX = $val->x;
//
//    if ($valX < 0) {
//        $valX *= -1;
//    }
//
//    if ($valX > $maxX) {
//        $maxX = $valX;
//    }
//
//    $valY = $val->y;
//
//    if ($valY < 0) {
//        $valY *= -1;
//    }
//
//    if ($valY > $maxY) {
//        $maxY = $valY;
//    }
//
//    $valZ = $val->z;
//
//    if ($valZ < 0) {
//        $valZ *= -1;
//    }
//
//    if ($valZ > $maxZ) {
//        $maxZ = $valZ;
//    }
//}
//
//$max = max(array($maxX, $maxY, $maxZ));
//
//var_dump(-2 * -1);