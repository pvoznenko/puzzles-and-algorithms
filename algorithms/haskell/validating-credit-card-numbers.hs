module validatingCreditCardNumbers where

{-
The algorithm follows these steps:

* Double the value of every second digit beginning with the rightmost.
* Add the digits of the doubled values and the undoubled digits from the original number.
* Calculate the modulus of the sum divided by 10.

If the result equals 0, then the number is valid.

Example of the results of each step on the number 4012888888881881.

* In order to start with the rightmost digit, we produce a reversed list of digits. Then, we double every second digit.
    ** Result: [1,16,8,2,8,16,8,16,8,16,8,16,2,2,0,8].
* We sum all of the digits of the resulting list above. Note that we must again split the elements of the list into their
  digits (e.g. 16 becomes [1, 6]).
    ** Result: 90.
* Finally, we calculate the modulus of 90 over 10.
    ** Result: 0.

Since the final value is 0, we know that the above number is a valid credit card number. If we make a mistake in typing
the credit card number and instead provide 4012888888881891, then the result of the last step is 2, proving that the
number is invalid.

-}

toDigits :: Integer -> [Integer]
toDigits 0 = []
toDigits n = toDigits (n `div` 10) ++ [n `mod` 10]

toDigitsRev :: Integer -> [Integer]
toDigitsRev n = reverse (toDigits n)

doubleSecond :: [Integer] -> [Integer]
doubleSecond [] = []
doubleSecond (x : y : xs) = x : 2 * y : doubleSecond xs
doubleSecond a = a

sumDigits :: [Integer] -> Integer
sumDigits [] = 0
sumDigits (x : xs)
  | x >= 10 = sum (toDigits x) + sumDigits xs
  | otherwise = x + sumDigits xs

isValid :: Integer -> Bool
isValid n = (sumDigits (doubleSecond (toDigitsRev n)) `mod` 10) == 0

-- isValid 4012888888881881 -> True
-- isValid 4012888888881891 -> False