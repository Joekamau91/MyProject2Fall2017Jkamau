// COSC 455 - Programming Languages: Implementation and Design
// Project 2

// NAME: <Joseph Kamau>
import scala.collection.mutable.Stack

//function to test if an int is prime
def prime(n: Int): Boolean = {
  (2 until n) forall (n % _ != 0)
}

//funtion to test if 2 numbers are twinprimes
def twinPrime(n: Int, j: Int): Boolean = {
  if (prime(n) && prime(j)) {
    if ((n - j == 2) || (n - j == -2)) {
      return true
    }
    else
      return false
  }
  else
    return false
}

//funtion to return list of prime numbers
// up to defined maximum list
def twinPrimeList(n: Int): List[Int] = {
  var alist = Stack[Int]()
  twinPrimeListHelp(n, alist)
}

def twinPrimeListHelp(n: Int, alist: Stack[Int]): List[Int] = {
  if (prime(n)) {
    if (twinPrime(n, n - 2)) {
      if (!alist.contains(n))
        alist.push(n)
      alist.push(n - 2)
    }
    if (!n.equals(5)) {
      twinPrimeListHelp(n - 1, alist)
    }
    else
      return alist.toList
  }

  else {
    twinPrimeListHelp(n - 1, alist)

  }
}

//goldbach function
def goldbach(n: Int): Unit = {
  if ((n > 2) && (n % 2 == 0)) {
    var j: Int = 0
    var g: Int = n
    goldhelp(n, j, g)
  }
  else
    println("The interger is not positive or 2")
}

def goldhelp(n: Int, j: Int, g: Int): Unit = {
  if ((prime(g)) && (prime(j))) {
    if (!(g + j == n)) {
      var alpha = j + 1
      var beta = g - 1
      goldhelp(n, alpha, beta)
    }
    else
      println("Goldbach for " + n + " returns: " + g + " , " + j)
  }
  else {
    var alpha = j + 1
    var beta = g - 1
    goldhelp(n, alpha, beta)
  }
}


//funtion calls for test cases
//Test #1
var josh: Int = 37
prime(josh)

//Test #2
var num1: Int = 41
var num2: Int = 43
twinPrime(num1, num2)

//Test #3
var numlist: List[Int] = twinPrimeList(50)

//Test #4
goldbach(28)
