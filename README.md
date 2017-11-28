Scala Checkers
==============
Scala Checkers is an extension to ScalaCheck standards generators.
### Usage
```
libraryDependencies += "com.servicerocket" %% "scala-checkers" % version
libraryDependencies += "org.scalacheck" %% "scalacheck" % version
```
Make sure to add a compatible ScalaCheck dependency explicitly as none will be
provided transitively (provided scope).

Use in your tests:
```scala
import com.servicerocket.checkers.Checkers

Checkers.instantGen   // Java Instant Gen
Checkers.timestampGen // Timestamp Gen
Checkers.urlGen       // URL Gen
Checkers.mimeTypeGen  // Mimetype Gen
```
### Compatibility Matrix
|  Scala Checkers | ScalaCheck     | Scala  |
| --------------- | -------------- | ------ |
| `0.1.0`         | `1.13.5`       | `2.11` |