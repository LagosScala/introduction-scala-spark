package tweetclient

import com.typesafe.scalalogging.LazyLogging
import twitter4j.Status

import scala.annotation.tailrec


object SimpleTweetApp extends App with LazyLogging{

  val tags = List("Election", "Nigeria Politics", "Nigeria decides", "Atiku", "Buhari")

  val scraper = new TwitterClient()
  //How to use the results
  val tweets = scraper.recursiveExtract(tags)
//  val tweetsText = scraper.getTweetText(tweets)
  logger.info(s"Extracted tweets for given tags, has size of ${tweets.size}")

  scraper.writeToFile(tweets, scraper.getTweetText, "lagos-scala")
}