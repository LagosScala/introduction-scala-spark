//package gui
//
//import java.awt.BorderLayout
//import java.awt.Dimension
//import javax.swing.JFrame
//import javax.swing.JScrollPane
//import javax.swing.JTextArea
//
//import scala.swing._
//import scala.swing.{SimpleSwingApplication, event}
//import scala.swing.event._
//
//
//object TweetSwingPanel{
//
//  def showframe = {
//    val textArea = new JTextArea
//    textArea.setText("Hello, Swing World!")
//    val scrollPane = new JScrollPane(textArea)
//
//    val frame = new JFrame("Hello, Swing")
//    frame.getContentPane.add(scrollPane, BorderLayout.CENTER)
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
//    frame.setSize(new Dimension(600, 400))
//    frame.setLocationRelativeTo(null)
//    frame.setVisible(true)
//  }
//
//}