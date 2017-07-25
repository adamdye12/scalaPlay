package controllers

import akka.util.ByteString
import play.api._
import play.api.http.HttpEntity
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Hello World"))
  }

  def redirect = Action {
    Redirect("http://github.com")
  }

  def dynamic(input: String) = Action{
    Ok(input)
  }

  def static = Action{
    Ok ("static")
  }

  def default(string: String) = Action{
    Ok ("This is the " + string)
  }

  def set (string: String) = Action{
    Ok(string)
  }

  def optional (option: Option[String]) = Action{
    Ok("The optinal string is " + option.getOrElse(".. hang on, there is no string here"))
  }

  val ok = Ok("Hello world!")
  val notFound = NotFound
  val pageNotFound = NotFound(<h1>Page not found</h1>)
  val badRequest = BadRequest("Error happened")
  val oops = InternalServerError("Oops")
  val anyStatus = Status(488)("Strange response type")

  def helperOk = Action{
    ok
  }

  def helperNotFound = Action{
    notFound
  }

  def helperPageNotFound = Action{
    pageNotFound
  }

  def helperBadRequest = Action{
    badRequest
  }

  def helperOops = Action{
    oops
  }

  def helperAnyStatus = Action{
    anyStatus
  }

  def hello(name: String) = Action {
    Ok("Hello " + name + "!")
  }

  def helloBob = Action {
    Redirect(routes.Application.hello("Bob"))
  }
  def todo = TODO

  def sameRoute1 = Action {
    Ok("This is the first action")
  }

  def sameRoute2 = Action {
    Ok("This is the second action")
  }

  def createCookie = Action { implicit request: Request[AnyContent] =>
    Ok("Cookie Created").withCookies(Cookie("theme", "blue"))
  }

  def viewCookie = Action { implicit request: Request[AnyContent] =>
    Ok("cookies : " + request.cookies.get("theme"))
  }

  def deleteCookie = Action { implicit request: Request[AnyContent] =>
    Ok("Cookie deleted").discardingCookies(DiscardingCookie("theme"))
  }

  def createSession = Action { implicit request: Request[AnyContent] =>
    Ok("Session Created").withNewSession
  }

  def viewSession = Action { implicit request: Request[AnyContent] =>
    Ok("session : " + request.session.get("connected"))
  }



  /*def viewSession = Action { request =>
    request.session.get("connected").map { user =>
      Ok("Hello " + user)
    }.getOrElse {
      Unauthorized("Oops, you are not connected")
    }
  }*/

}



