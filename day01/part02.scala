import scala.io.StdIn.readLine
import scala.io.Source.fromFile
import scala.collection.mutable.ListBuffer

@main def part02() =
  val bufferedSource = fromFile("input.txt")
  var topThree = new ListBuffer[Int]()
  var currSum = 0
  for (lines <- bufferedSource.getLines()) {
    if lines.trim.isEmpty then
      if topThree.length < 3 then
        topThree += currSum
      else
        if currSum > topThree(0) then
          topThree.update(0, currSum)
      currSum = 0
      topThree = topThree.sorted
    else 
      currSum += lines.toInt
  }
  bufferedSource.close()
  println(s"The answer is: ${topThree.sum}")

