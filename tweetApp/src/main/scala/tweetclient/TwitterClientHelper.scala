///**
//  *
//  * With Configuration files i.e twitter4j.properties, an instance of TwitterFactory
//  * is able to read the token and keys, hence except you have mutliple configuratoion
//  * using FileInputStream to read the twitter4j.properties may not be neede
//  //Read property files suing Java util Properties
//  //  private val properties = new Properties()
//  //  private val in = new FileInputStream("twitter4j.properties")
//  //  properties.load(in)
//  //  in.close()
//  //
//  //
//  //  val consumerKey = properties.getProperty("oauth.consumerKey")
//  //  val consumerSecret = properties.getProperty("oauth.consumerSecret")
//  //  val accessToken = properties.getProperty("oauth.accessToken")
//  //  val accessTokenSecret = properties.getProperty("oauth.accessTokenSecret")
//
//    This can now be passed to configuration builder -- the 2nd approach proposed by twitter4j themselves.
//  **/
//package tweetclient
//
//import java.io.FileInputStream
//import java.util
//import java.util.Properties
//
//import com.mongodb.{BasicDBObject, DBObject}
//import db.MongoDatabaseHelper._
//import org.mongodb.scala._
//import org.mongodb.scala.bson.{BsonDocument, BsonInt32, BsonString}
//import twitter4j._
//import twitter4j.conf.ConfigurationBuilder
//import db.Helpers._
//
//
//object TwitterClientHelper {
//
//  val tf = new TwitterFactory()
//  val twitter = tf.getInstance
//
////  val statuses = twitter.getFavorites
////  println("Showing friends timeline.")
////  val it = statuses.iterator
//
//  def searchTweets(query: Seq[String]) = {
//    //Ensure that listener from the GUI presents the tweets as a Sequence of String
//    for (elem <- query) {
//      val querystatus = twitter.search(new Query(elem)).getTweets
//      querystatus.forEach(querystat => {
//        val basicdbobject :Document = Document(
//          "username" -> querystat.getUser.getScreenName,
//          "retweet" -> querystat.getRetweetCount,
//          "source" -> querystat.getSource,
//          "tweet_text" -> querystat.getText,
//          "tweet_ID" -> querystat.getId,
//          "mentions" -> querystat.getUserMentionEntities.length
//        )
//        collection.insertOne(basicdbobject).printResults()
//      })
//    }
//    //Short hand version of the above
//    //query.foreach(q => twitter.search(new Query(q)).getTweets)
//  }
//
//}
//
//
//
//
//
//
//
//
//
////NOT USED
//
////Decision to either send the whole tweets to a mongodb or do some cleaning
//// Or send some cleaned data to mongo while some goes to Mariadb
////querystatus.forEach(querystat => println(querystat.getText))
////querystatus.forEach(querystat => {
////val status = TwitterObjectFactory.getRawJSON(querystat)
//////        val bsonDocument = JSON.parse(status)
//////        val doc = bsonDocument.get("statuses")
////        println(doc)
//
////collection.insertOne(Document(jsonobject))