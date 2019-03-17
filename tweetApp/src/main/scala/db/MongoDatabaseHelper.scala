package db

import com.mongodb.BasicDBObject
import com.mongodb.client.model.Indexes
import com.typesafe.config._
import org.mongodb.scala.{model, _}
import org.mongodb.scala.model.{IndexModel, IndexOptions}



//TODO: Write Extracted Data to DB
/**This can be modified to make use of a reference conf file, check typesafe config
  * website under complex app examples, meanwhile we can still work with the config in
  * resource for now
  */
object MongoDatabaseHelper {

  val configmongo = ConfigFactory.load("mongoconf")
  println(configmongo.getString("mongodbclient.host"))

  private val host: String = configmongo.getString("mongodbclient.host")
  private val port: String = configmongo.getString("mongodbclient.port")


  //create a uri off the extracted config using string literal
  val mongoClient: MongoClient = MongoClient(s"mongodb://$host:$port")

  def listdb = {
    mongoClient.listDatabases.subscribe(
      //Need to refactore this
      (data: Document) => println(data.toBsonDocument.get("name").asString.getValue),
      (error: Throwable) => println(s"Query failed: ${error.getMessage}"),
      () => println("Done")
    )
  }

  //this was chained in a functional way to get collection

      val database :MongoDatabase = mongoClient.getDatabase("tweetdbtest")

      val collection: MongoCollection[Document] = database.getCollection("test")
      //Create Unique Index for collection
      collection.createIndexes(Seq(
        IndexModel(Indexes.ascending("tweet_ID"),
          IndexOptions().background(false).unique(true))
    ))

//    val trydocument: Document = Document("_id" -> 0, "name" -> "MongoDB", "type" -> "database",
//      "count" -> 1, "info" -> Document("x" -> 203, "y" -> 102))
//
//    collection.insertOne(trydocument)
}