package tweetclient

import com.typesafe.scalalogging.LazyLogging
import org.scalatest._
import twitter4j.conf.ConfigurationBuilder
import twitter4j.{Status, _}
import java.io._

import scala.collection.JavaConverters._
import scala.util.{Failure, Success, Try}

class TweetScraperTestSuit extends WordSpec with Matchers with LazyLogging{

  logger.info("Running test Script")

  val scraper = new TwitterClient()
  val query = "Cardi B"

  "Twitter Scraper" should {
    "Assert that configuration is okay" in {
      val loader = scraper.loadTwitterFactory()
      loader.connect shouldBe true
    }


    "Should return a json of search query" in {
      val tweets = scraper.retrieveStatus(query, RetrievedTweets(List[Status]()))
      tweets.size should be > 1
      scraper.getTweetText(tweets).size > 1
      scraper.writeToFile(tweets, scraper.getTweetText, "tweets")
    }
  }

  //Implement ssimple Scala scraper
}


