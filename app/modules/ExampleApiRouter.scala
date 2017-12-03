package modules

import javax.inject.Inject

import controllers.ExampleApiController
import play.api.Logger
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class ExampleApiRouter @Inject()(controller: ExampleApiController)
  extends SimpleRouter {

  override def routes: Routes = {
    case GET(p"/api") =>
      Logger.info(s"${getClass.getName} ....")
      controller.index
  }
}