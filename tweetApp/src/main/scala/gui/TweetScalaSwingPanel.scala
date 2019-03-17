//package gui
//
//import tweetclient.TwitterClientHelper
//
//import scala.swing.{Button, Dimension, FlowPanel, GridPanel, Label, MainFrame, SimpleSwingApplication, Swing, TextField}
//import scala.swing.event._
//
//
//object TweetScalaSwingPanel extends SimpleSwingApplication{
//
//  def newField = new TextField {
//    text = "Add Tweet"
//    columns = 10
//  }
//
//  val hashTag = newField
//  //val word = newField
//
//  //(hashTag, word)
//  //        reactions += { // Here is what happens when any of the edit is done
//  //            case EditDone()
//  //        }
//  lazy val ui = new FlowPanel(new Label(" Hash Tag = "),hashTag){ //new Label(" word = "), word){ -- Ensure to clean this up when you finally remove word textfield
//    border = Swing.EmptyBorder(15, 10, 10, 10)
//  }
//
//  lazy val addButton = new Button {
//    //Implements Add Button to be added to ui.contents
//    text = "Submit!"
//    reactions += {
//      case ButtonClicked(_) =>
//        val hashText = Seq(hashTag.text)  //text = "Submitted" //Saying case ButtonClicked then text = "submitted"
//        TwitterClientHelper.searchTweets(hashText)
//      //TODO: Add functionality to do a comma seperated entry in gui column
//    }
//  }
//  ui.contents += addButton
//
//  def top = new MainFrame {
//    title = "Tweet Box"
//    contents = ui
//
//    size = new Dimension(600, 480)
//  }
//
//}