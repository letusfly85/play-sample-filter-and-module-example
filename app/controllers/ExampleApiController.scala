package controllers

import javax.inject._

import modules.ExampleAction
import play.api.libs.json.JsObject
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class ExampleApiController @Inject()(exampleAction: ExampleAction, cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = exampleAction { implicit request: Request[AnyContent] =>
    Ok(JsObject.empty)
  }
}
