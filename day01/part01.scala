import scala.io.StdIn.readLine
import scala.io.Source.fromFile

@main def part01() =
  val bufferedSource = fromFile("input.txt")
  var currSum = 0
  var currMax = 0
  for (lines <- bufferedSource.getLines()) {
    if lines.trim.isEmpty then
      if currSum > currMax then currMax = currSum
      currSum = 0
    else 
      currSum += lines.toInt
  }
  bufferedSource.close()
  println(s"The answer is: $currMax")
