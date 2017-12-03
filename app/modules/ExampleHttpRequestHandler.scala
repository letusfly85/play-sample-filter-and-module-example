package modules

import javax.inject.Inject

//import akka.routing.Router
import play.api.Logger
import play.api.http._
import play.api.mvc.RequestHeader
import router.Routes

class ExampleHttpRequestHandler @Inject()(errorHandler: HttpErrorHandler,
                                          configuration: HttpConfiguration, filters: HttpFilters,
                                          //fooRouter: foo.Routes, barRouter: bar.Routes
                                          router: Routes,
                                          exampleApiRouter: ExampleApiRouter
                                          ) extends DefaultHttpRequestHandler (
  //fooRouter,
  router, errorHandler, configuration, filters
) {

  val compositeRoutes = exampleApiRouter.routes.orElse(router.routes)

  override def routeRequest(request: RequestHeader) = {
    Logger.logger.info(s"${getClass.getName} ${request.host}")
    request.host match {
      case _ => compositeRoutes.lift(request)
      //case "foo.example.com" => fooRouter.routes.lift(request)
      //case "bar.example.com" => barRouter.routes.lift(request)
      //case _ => super.routeRequest(request)
    }
  }
}