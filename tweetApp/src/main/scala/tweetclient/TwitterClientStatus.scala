package tweetclient

import twitter4j.{Status, Twitter}




final case class TwitterClientStatus(client: Twitter, connect:Boolean)

/***
  * Combine all searches in one instance of the Twitter CLients
  *
  * Extract the lenght too though
  * @param statuses
  */
final case class RetrievedTweets(statuses: List[Status]) {
  val size: Int = statuses.size
  //You can do a lot of things here like add the lenght of tweets
  val addStatus: List[Status] => RetrievedTweets = (newStatus: List[Status]) => RetrievedTweets(statuses ++ newStatus)

  val retrieveTexts: List[String] = statuses.map(x => x.getText)
}

