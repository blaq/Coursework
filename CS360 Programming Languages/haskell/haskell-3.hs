import Lab7

-- 5.1 (lab 5, question 1)
gcdMine :: Integral a => a -> a -> a
gcdMine x 0 = x
gcdMine x y = gcdMine y (x `mod` y)
gcdCheck :: Integral a => a -> a -> (a, a, [Char])

gcdCheck x y = (myAnswer, correctAnswer, comment)
  where 
    myAnswer      = gcdMine x y
    correctAnswer = gcd x y
    comment       = if myAnswer == correctAnswer then "Matches" else "Does not Match"

-- 5.2 (lab 5, question 2)
fibonacci :: Int -> Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n =  fibonacci(n-1) + fibonacci(n-2)

fibCheck n = [fibonacci x | x <- [0..n]]

-- 5.3 (lab 5, question 3)
count :: (Eq a, Num b) => a -> [a] -> b
count _ [] = 0
count a (x:xs)
 | a == x = 1 + count a xs
 | otherwise = count a xs

-- 5.5 (lab 5, question 5)
sanitize [] = ""
sanitize (x:ls) = (if x == ' ' then "%20"++sanitize ls else [x]++sanitize ls)

-- 6.1.a (lab 6, question 1, part a)
-- #1
multByTen :: Num b => [b] -> [b]
multByTen ls = map (*10) ls

-- 6.1.e (lab 6, question 1, part e)
-- #2
removeSpaces :: [Char] -> [Char]
removeSpaces st = filter (/=' ') st

-- 6.1.f (lab 6, question 1, part f)
-- #3
fiftyFive :: (Foldable t, Eq a, Num a) => t a -> Bool
fiftyFive ls = any (==55) ls

-- 6.1.i (lab 6, question 1, part i)
-- #4
powerList :: (Integral b, Num c) => [b] -> [c]
powerList ls = zipWith (^) (repeat 10) ls

-- 6.1.k (lab 6, question 1, part k)
-- #5
allEven :: (Foldable t, Integral a) => t a -> Bool
allEven ls = all even ls

-- 6.2.a (lab 6, question 2, part a)
lambdaPlus :: Integer -> Integer -> Integer
lambdaPlus = \x -> \y -> x + y

-- 6.2.a (lab 6, question 2, part a)
roundSquare :: Double -> Integer
roundSquare = \x -> round (sqrt x)

--6.4 (lab 6, question 4)
altJ :: [(Double, Double)] -> [(Double, Double, Double)]
altJ = map (\(a,b) -> (a,b,(sqrt(a^2 + b^2))))
