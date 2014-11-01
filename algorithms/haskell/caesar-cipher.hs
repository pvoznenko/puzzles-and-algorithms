import Data.Char

int2char :: Int -> Char -> Char
int2char l c = chr (ord c + l)

char2int :: Char -> Char -> Int
char2int c cr = ord c - ord cr

int2let :: Int -> Char
int2let n = int2char n 'a'

let2int :: Char -> Int
let2int c = char2int c 'a'

int2upp :: Int -> Char
int2upp n = int2char n 'A'

upp2int :: Char -> Int
upp2int c = char2int c 'A'

shiftChar :: (Int -> Char) -> (Char -> Int) -> Int -> Char -> Char
shiftChar i2c c2i n c = i2c ((n + c2i c) `mod` 26)

shift :: Int -> Char -> Char
shift n c
  | isLower c = shiftChar int2let let2int n c
  | isUpper c = shiftChar int2upp upp2int n c
  | otherwise = c

encode :: Int -> String -> String
encode n xs = [shift n x | x <- xs]

{-
    usage: encode 13 "Think like a Fundamentalist Code like a Hacker"
    output: "Guvax yvxr n Shaqnzragnyvfg Pbqr yvxr n Unpxre"
-}