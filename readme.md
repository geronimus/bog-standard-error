# Bog Standard Error

## Description

A little package to help the programmer to easily produce general-purpose errors with structured and informative messages.

## Usage

```scala
StdError.illegalArg(
  parameter = "outputDir",
  expected = "A String representing an existing directory on the local file system.",
  found = outputDir,
  explanation = s"$outputDir was found not to exist on the local file system."
)

/* This will produce an IllegalArgumentException with a message like following:
 *
 * Illegal Argument:
 *   Parameter: outputDir
 *   Expected: A String representing an existing directory on the local file system.
 *   Found: /Users/me/Documents/project/examples
 *
 * /Users/me/Documents/project/examples was found not to exist on the local file system.
 *
 * The explanation argument is optional. (eg, For additional context or info.)
 */

StdError.illegalState(
  source = "user.space.MySimpleDatabaseConnection",
  rule = "You cannot execute a query when the target data source has not been defined.",
  violation = s"Executed \"${ command }\" when the connection string is null."
)

/* This will produce an IllegalStateException with a message like this:
 * 
 * Illegal State:
 *   Source: user.space.MySimpleDatabaseConnection
 *   Rule: You cannot execute a query when the targat data source has not been defined.
 *   What you did wrong: Executed "SELECT * FROM user.audit_table" when the connection string is null.
 *
 * The violation (What you did wrong) argument is optional.
 *
 * There is an override of this method that allows an object reference, so that you can pass is the
 * calling class using a `this` reference.
 *
 */

StdError.illegalState(
  source = this,
  rule = "You cannot execute a query when the target data source has not been defined.",
  violation = s"Executed \"${ command }\" when the connection string is null."
)

```

