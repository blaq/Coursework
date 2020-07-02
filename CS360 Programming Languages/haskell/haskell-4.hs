{-	Lab 4 Ethan Black	-}
module Main where
import System.Environment


-- Problem #1
gallons :: Fractional a => a -> a
gallons l = l * 0.26417
{- ANSWER:	gallons 62.3 == 16.457791	-}
usd :: Fractional a => a -> a
usd d = d * 0.76
{- ANSWER:	usd 78.4 == 59.584	-}
price :: Fractional a => a -> a -> a
price l d = (usd d) / (gallons l)
{- ANSWER:	price 62.3 78.4 == 3.6204129703676515	-}

-- Problem #2
degToRad :: Floating a => a -> a
degToRad deg = deg * ( pi/180 )
{- degToRad 45 == 0.7853981633974483	-}
flightDistance :: (Double, Double) -> (Double, Double) -> Double
flightDistance (x1, y1) (x2, y2) = 
 r * acos (
 cos ( degToRad x1 ) *
 cos ( degToRad x2 ) *
 cos ( degToRad y1 - degToRad y2 ) +
 sin ( degToRad x1 ) *
 sin ( degToRad x2 ) )
 where  r = 3963
{- ANSWER:	flightDistance (45.0, 122.0) (21.0, 158.0) == 2631.8416987553624	-}

-- Problem #3
factorial :: Integer -> Integer
factorial n 
 | n < 0 = error "Negative Number Alert!"
 | otherwise = foldl (*) 1 [1..n]
{- ANSWER:	factorial 99 == 933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761565182862536979208272237582511852109168640000000000000000000000	-}

-- Problem #4
isEven :: Integral a => a -> [Char]
isEven n = if n `mod` 2 == 0 then "even" else "odd"
{- ANSWER:	isEven 2 == "even"	-}

-- Problem #5
sumOfCubes :: (Num a, Enum a) => a -> a -> a
sumOfCubes h t = sum [ n^3 | n <- [h..t] ]
{- ANSWER:	sumOfCubes 1000 2000 == 3754500750000	-}

-- Problem #6
closedForm :: Fractional a => a -> a
closedForm n = (n*(n+1)*(2*n+1))/6
{- ANSWER:	closedForm 10 == 385.0	-}
recRelation :: (Num a, Enum a) => a -> a
recRelation n = sum [ x^2 | x <- [1..n] ]
{- ANSWER:	recRelation 10 == 385	-}
confirmFunc :: (Eq a, Fractional a, Enum a) => a -> Bool
confirmFunc n = closedForm n == recRelation n
{- ANSWER:	confirmFunc 10 == true	-}

-- Problem #7
count1 :: (Eq a, Num b) => [a] -> a -> b
count1 [] _ = 0
count1 (x:xs) a = if x == a then 1 + count1 xs a else count1 xs a
{- ANSWER:	count1 [1,2,3,2,5,1,4] 1 == 2	-}
count2 :: (Eq a, Num b) => [a] -> a -> b
count2 ls a = sum [ 1 | x <- ls,  x == a ]
{- ANSWER:	count2 "western oregon wolves (wow) win winter wrestling" 'w' == 7	-}

-- Problem #8
maxList :: Ord a => [a] -> a 
maxList [t] = t
maxList (h:ls) = max h ( maxList ls )
{- ANSWER:	maxList [1,2,3,2,1] == 3	-}

-- Problem #9
removeSpaces :: [Char] -> [Char]
removeSpaces st = filter (/=' ') st
{- ANSWER:	removeSpaces " h e l p " == "help"	-}
filterEven :: Integral a => [a] -> [a]
filterEven ls = filter (odd) ls
{- ANSWER:	filterEven [1,2,3] == [1,3]	-}
multListByTwo :: Num b => [b] -> [b]
multListByTwo ls = map (*2) ls
{- ANSWER:	multListByTwo [1,2,3] == [2,4,6]	-}
fiftyFive :: (Foldable t, Eq a, Num a) => t a -> Bool
fiftyFive ls = any (==55) ls
{- ANSWER:	fiftyFive [1,2,3,55] == True	-}
allEven :: (Foldable t, Integral a) => t a -> Bool
allEven ls = all odd ls
{- ANSWER:	allEven [1,3,55] == True	-}

-- Problem #10
isPrime :: Integral t => t -> Bool
isPrime i = sieve 2
 where
  sieve f 
   | f^2 > i = True
   | i `rem` f == 0 = False
   | otherwise = sieve (f+1)
{- ANSWER:	isPrime 7 == True	-}
primeList :: Integral a => Int -> Int -> [a]
primeList h t = drop (h-1) $ take (t-1) $ filter isPrime [2..]
{- ANSWER:	primeList 1000 1020 == [7919,7927,7933,7937,7949,7951,7963,7993,8009,8011,8017,8039,8053,8059,8069,8081,8087,8089,8093,8101]	-}

-- Problem #11
factor :: Integral t => t -> [t]
factor n = filter isPrime $ filter (\x -> n `mod` x == 0) (2:[3,5..999999])
-- Only works on integers equal to or less than 999,966,000,289
{- ANSWER:	factor 175561 == [419]	-}
{- ANSWER:	factor 62451532000 == [2,5,11,13,23,47,101]	-}

-- Problem #12
main :: IO ()
main = do
args <- getArgs
print $ factor (read (head args)::Integer)
{- ANSWER:	PartI.exe 5698 will result with [2,7,11,37]	-}