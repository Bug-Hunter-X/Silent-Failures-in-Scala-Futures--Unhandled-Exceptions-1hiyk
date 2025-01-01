```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClassImproved(implicit ec: ExecutionContext) {
  def myMethodImproved(i: Int): Future[Int] = Future {
    if (i < 0) throw new IllegalArgumentException("Input must be non-negative")
    i * 2
  }.recover {
    case e: IllegalArgumentException => 0 // Handle exception with default value 0
    case _ => 0 // Handle any other exception with default value 0. 
  }
  //Alternative with recoverWith for more sophisticated handling
  def myMethodImprovedRecoverWith(i: Int): Future[Int] = Future {
    if (i < 0) throw new IllegalArgumentException("Input must be non-negative")
    i * 2
  }.recoverWith {
    case e: IllegalArgumentException => Future.successful(0) // Handle exception with default value 0
    case _ => Future.successful(0)// Handle any other exception with default value 0. 
  }
}
```