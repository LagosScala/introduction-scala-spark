package tweetclient

import java.io.{BufferedWriter, FileWriter}

import twitter4j._

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}
import scala.collection.JavaConverters._

class TwitterClient {


  def retrieveStatus(query: String, statuses: RetrievedTweets): RetrievedTweets = {
    val client: Twitter = this.loadTwitterFactory().client
    val status = client.search(new Query(query)).getTweets.asScala.toList
    statuses.addStatus(status)
  }

  /***
    * Recursively extract tweets for a list of Strings
    * @param tags - List of tags to search on a single call to search.
    * @return
    */
  def recursiveExtract(tags: List[String]): RetrievedTweets = {
    @tailrec
    def mid(xs: List[String], acc: RetrievedTweets) :RetrievedTweets = {
      xs match {
        case Nil => acc
        case x :: tail => mid(tail,  retrieveStatus(x, acc))
      }
    }
    mid(tags, RetrievedTweets(List[Status]()))
  }

  def loadTwitterFactory() :TwitterClientStatus = {
    val twitterFactory = new TwitterFactory()
    //Need to find a way to ensure to check that there is a connection
    val twitterInstance = twitterFactory.getInstance()
    val configuration: Try[AccountSettings] = Try(twitterInstance.getAccountSettings)
    configuration match {
      case Success(_) => TwitterClientStatus(client = twitterInstance, connect = true)
      case Failure(_) => TwitterClientStatus(client = twitterInstance, connect = false)
    }
  }

  def getTweetText(status: RetrievedTweets): List[String] = status.retrieveTexts

  /***
    * Write tweet information to file, you can pass in a function too to apply on tweets
    * @param status
    */
  def writeToFile(status: RetrievedTweets, f: RetrievedTweets=> List[String], filename:String): Unit = {
    val file = s"$filename.csv"
    val writer = new BufferedWriter(new FileWriter(file))
    f(status).foreach(writer.write)
    writer.close()
  }

}