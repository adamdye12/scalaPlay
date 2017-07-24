package controllers

import akka.util.ByteString
import play.api._
import play.api.http.HttpEntity
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Hello World"))
  }

  def got = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index("Got request [" + request + "]"))
  }

  def hello(name: String) = Action {
    Ok("Hello" +name)
  }

  def head = Action {
    Result(
      header = ResponseHeader(200, Map.empty),
      body = HttpEntity.Strict(ByteString("Hello world!"), Some("text/plain")))
  }
  
  val Ok = new Status(OK)

  class Status(statue: Int) extends Result(header = ResponseHeader(status), body = HttpEntity.NoEntity)
}