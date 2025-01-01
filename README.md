# Silent Failures in Scala Futures: Unhandled Exceptions

This example demonstrates a common error in Scala involving unhandled exceptions within `Future` objects.  When an exception occurs within a `Future`'s computation and is not explicitly handled (using `recover` or `recoverWith`), the `Future` transitions to a failed state. However, this failure isn't immediately apparent unless explicitly checked, leading to subtle bugs that are hard to track down.

The `BuggyFuture.scala` file showcases this problem. The `myMethod` function throws an `IllegalArgumentException` if the input is negative. However, the exception isn't caught, causing the `Future` to fail silently.

The `ImprovedFuture.scala` demonstrates a corrected version using the `recover` method to gracefully handle the exception, returning a default value (0) in case of an error.  This prevents silent failures and makes the code more robust.