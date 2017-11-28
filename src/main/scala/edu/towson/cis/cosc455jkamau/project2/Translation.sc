// COSC 455 - Programming Languages: Implementation and Design
// Project 2

// NAME: <Joseph Kamau>


val chinese: List[String] = List("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi")
val english: List[String] = List("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

//Test cases
go(List("yi","nine","six","ba"))
go(List("yi","josh","three","si"))

def go(alist: List[String]): Unit = {
  //This will define and sort values  passed in var
  var output = List[Int]()
  output = sort(alist)

  //creates and provides output
  val addition = add(output)
  val multiplication = multi(output)
  println("Translation:" + output)
  println("The Total Added " + addition)
  println("The Total Multiplied Result  " + multiplication)
  println()
}

//sort function
//Also checks list for shared vars
def sort(alist: List[String]): List[Int] = {
  alist match {
    case Nil => Nil
    case head :: tail =>
      if (chinese.contains(head)) {
        chinese.indexOf(head) :: sort(tail)
      }
      else if (english.contains(head)) {
        english.indexOf(head) :: sort(tail)
      }
      else
        sort(tail)
  }
}

//output for list added
def add(alist: List[Int]): Int = {
  alist.foldLeft(0)(_ + _)
}

//output for list multiplied
def multi(alist: List[Int]): Int = {
  alist.foldLeft(1)(_ * _)
}
