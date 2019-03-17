package db

//TODO Implement MariaDB in place of Mongodb 
import com.typesafe.config.ConfigFactory

object MariaDatabaseHelper {

  val configmongo = ConfigFactory.load("mariadbconf")
  println(configmongo.getString("mariadbclient.host"))
}