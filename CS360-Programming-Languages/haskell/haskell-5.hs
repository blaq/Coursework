--7.1 (lab 7, question 1)
--foldl (*) 6 [5,3,8] = (((6 * 5) * 3) * 8) = 720
--foldr (*) 6 [5,3,8] = (5 * (3 * (8 * 6))) = 720

module Lab7
(
customLength,
convertIntToStringLeft,
convertIntToStringRight,
specificListSize,
otherExpress,
) where

import Data.Char

--7.2 (lab 7, question 2)
customLength :: Num p => [a] -> p
customLength [] = 0
customLength (x:ls) = customLength ls + 1

--7.3 (lab 7, question 3)
convertIntToStringLeft :: [Int] -> [Char]
convertIntToStringLeft [] = []
convertIntToStringLeft ls = convertIntToStringLeft (init ls) ++ [intToDigit (last ls)]

convertIntToStringRight :: [Int] -> [Char]
convertIntToStringRight [] = []
convertIntToStringRight (x:ls) = [intToDigit x] ++ convertIntToStringRight ls

--7.4.1 (lab 7, question 4, part 1)
--length (filter (<20) [1..100])
specificListSize = length $ filter (<20) [1..100]

--7.4.1 (lab 7, question 4, part 1)
--sum (map length (zipWith (flip (++)) ["love you", "love me"] ["i ", "you "]))
otherExpress = sum $ map length $ zipWith (flip (++)) ["love you", "love me"] ["i ", "you "]
