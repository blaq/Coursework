-- 1.3 (lab 1, question 3)
one_3 = sqrt(818281336460929553769504384519009121840452831049) 

-- 1.4 (lab 1, question 4)
one_4 = pred 'A'

-- 1.5 (lab 1, question 5)
one_5 x = even ((3*x)+1)


-- 2.2 (lab 2, question 2)
two_2 = [1,3..100]

-- 2.3 (lab 2, question 3)
two_3 = maximum ( init( tail ([99,23,4,2,67,82,49,-40])))

-- 2.4 (lab 2, question 4)
two_4 = 6:19:41:(-3):[]

-- 2.5.1 (lab 2, question 5, part 1)
two_5_1 = [ x | x <- [1..27], even x ]

-- 2.5.2 (lab 2, question 5, part 2)
two_5_2 = [ x | x <- [1,3..200], x `mod` 3 == 0, x `mod` 7 == 0 ]

-- 2.5.3 (lab 2, question 5, part 3)
two_5_3 = [ x | x <- [100..200], x `mod` 9 == 0, odd x ]

-- 2.5.5 (lab 2, question 5, part 5)
two_5_5 = length ([ x | x <- [(-10)..10], x < 0 ])

-- 2.6 (lab 2, question 6)
two_6 = zip [0..15] (['0'..'9'] ++ ['A'..'F'])


-- 3.1 (lab 3, question 1)
makeList n = [ [1..x] | x <- [1.. n] ]

-- 3.2 (lab 3, question 2)
sanitize xs = [ v | c <- xs,  v <- if c == ' ' then "%20" else [c] ]

-- 3.4 (lab 3, question 4)
--(*) will work with ints, doubles, floats
--(++) will work with strings and lists
--min will work with ints, doubles, floats

-- 4.1.a (lab 4, question 1, part a)
getSuit :: Int -> String 
getSuit 0 = "Heart"
getSuit 1 = "Diamond"
getSuit 2 = "Spade"
getSuit 3 = "Club"

-- 4.1.b (lab 4, question 1, part b)
dotProduct :: (Double,Double,Double) -> (Double,Double,Double) -> Double
dotProduct (a,b,c) (x,y,z) = (a*x) + (b*y) + (c*z)

-- 4.1.c (lab 4, question 1, part c)
reverseFirstThree :: [a] -> [a]
reverseFirstThree [] = []
reverseFirstThree (x:[]) = [x]
reverseFirstThree (x:y:[]) = [y,x]
reverseFirstThree (x:y:z:ls) = (z:y:x:ls)

-- 4.2.a (lab 4, question 2, part a)
feelsLike :: Double -> String
feelsLike temp
 | temp > 72 = "Hot"
 | temp == 72 = "The tempature of gods"
 | temp > 0 = "Cool"
 | otherwise = "Frostbite Central!"

-- 4.2.b (lab 4, question 2, part b)
feelsLike2 :: Double -> (Double,String)
feelsLike2 cel
 | fah > 72 = ( fah, "Oven-like" )
 | fah == 72 = ( fah, "The tempature of gods" )
 | fah > 0 = ( fah, "Cool" )
 | otherwise = ( fah, "Freezing")
 where fah = ( ( cel * (9/5) ) + 32 )

-- 4.4 (lab 4, question 4)
cylinderToVolume :: [(Double,Double)] -> [Double]
cylinderToVolume ls = [ vol | (r,h) <- ls, let vol = (pi*r*r*h) ]