Scala Checkers
==============
[![Build Status](https://travis-ci.org/servicerocket-labs/scala-checkers.svg?branch=master)](https://travis-ci.org/servicerocket-labs/scala-checkers)
![GitHub Action](https://github.com/servicerocket-labs/scala-checkers/actions/workflows/ci.yml/badge.svg)

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
|  Scala Checkers | ScalaCheck     | Scala           |
| --------------- | -------------- | --------------- |
| `0.1.0`         | `1.13.5`       | `2.11`          |
| `0.1.1`         | `1.13.5`       | `2.12`          |
| `0.1.2`         | `1.14.0`       | `2.13`, `2.12`, `2.11` |
