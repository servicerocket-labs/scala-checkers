package com.servicerocket.checkers

import java.lang.System.currentTimeMillis
import java.time.Instant

import org.scalacheck.Gen
import org.scalacheck.Gen.{alphaChar, alphaNumChar, alphaStr, choose, listOfN, nonEmptyListOf, numChar, oneOf}

/** Some more Scalacheck generators.
  *
  * @author Nader Hadji Ghanbari
  * @see https://www.scalacheck.org/files/scalacheck_2.11-1.13.4-api/index.html#org.scalacheck.Gen
  */
object Checkers {

  /** Generator generating random alphanumeric strings with provided length.
    *
    * @param length Fixed length of the generated string.
    * @return Generator generating random fixed-length strings.
    */
  def strGen(length: Int): Gen[String] = listOfN(length, alphaNumChar).map(_.mkString)

  /** Generator generating random strings, comprised of only alphabetic characters, with the provided length.
    *
    * @param length Fixed length of the generated string.
    * @return Generator generating random non-empty alpha strings.
    */
  def alphaStrGen(length: Int): Gen[String] = listOfN(length, alphaChar).map(_.mkString)

  /** Generator generating random strings, comprised of only numeric characters, with the provided length.
    *
    * @param length Fixed length of the generated string.
    * @return Generator generating random non-empty numeric strings.
    */
  def numStrGen(length: Int): Gen[String] = listOfN(length, alphaChar).map(_.mkString)

  /** Generator generating random non-empty alphanumeric strings with a maximum length.
    *
    * @param maxLength Maximum length of the generated string.
    * @return Generator generating random non-empty strings.
    */
  def strMaxGen(maxLength: Int): Gen[String] = nonEmptyListOf(alphaNumChar).map(_.take(maxLength)).map(_.mkString)

  /** Generator generating random non-empty strings, comprised of only alphabetic characters, with a maximum length.
    *
    * @param maxLength Maximum length of the generated string.
    * @return Generator generating random non-empty alpha strings.
    */
  def alphaStrMaxGen(maxLength: Int): Gen[String] = nonEmptyListOf(alphaChar).map(_.take(maxLength)).map(_.mkString)

  /** Generator generating random non-empty strings, comprised of only numeric characters with a maximum length.
    *
    * @param maxLength Maximum length of the generated string.
    * @return Generator generating random non-empty numeric strings.
    */
  def numStrMaxGen(maxLength: Int): Gen[String] = nonEmptyListOf(numChar).map(_.take(maxLength)).map(_.mkString)

  /** Generator generating random non-empty sentences.
    *
    * @return Generator generating random non-empty sentences.
    */
  def sentenceGen: Gen[String] = nonEmptyListOf(strMaxGen(6).suchThat(!_.isEmpty)).map(_.mkString(" "))

  /** Generator generating random booleans.
    *
    * @return Generator generating random booleans.
    */
  def boolGen: Gen[Boolean] = oneOf(true, false)

  /** Generator generating random ids comprising of only alphabetic characters.
    *
    * @return Generator generating random alpha ids.
    */
  def alphaIdGen: Gen[String] = alphaStrMaxGen(5).map(_.toUpperCase)

  /** Generator generating random ids comprising of only numeric characters.
    *
    * @return Generator generating random numeric string ids.
    */
  def numStrIdGen: Gen[String] = numStrMaxGen(5)

  /** Generator generating random ids of type `Long`.
    *
    * @return Generator generating random `Long` ids.
    */
  def numIdGen: Gen[Long] = choose(1L, 1000000L)

  /** Generator generating random urls.
    *
    * @return Generator generating random urls.
    */
  def urlGen: Gen[String] = for {
    protocol <- oneOf("http", "https")
    domain <- alphaStr
    port <- choose(1024, 9999)
    contextRoot <- alphaStr
  } yield s"$protocol://$domain:$port/$contextRoot"

  /** Generator generating random timestamps in epoch milliseconds format.
    * The generated value is between yesterday and tomorrow!
    *
    * @return Random timestamp generator.
    */
  def timestampGen: Gen[Long] = choose(-24 * 60 * 60 * 1000, 24 * 60 * 60 * 1000).map(_ + currentTimeMillis())

  /** Generator generating random instants. The generated value is between yesterday and tomorrow!
    *
    * @return Random instant generator.
    */
  def instantGen: Gen[Instant] = timestampGen.map(Instant.ofEpochMilli)

  /** Generator generating random mime types or content types, e.g. `application/json`, `image/png`.
    *
    * @return Generator generating random content types.
    */
  def mimeTypeGen: Gen[String] = Gen.oneOf("application/json", "image/png", "image/jpg", "text/xml", "text/html")

}