package modules

import javax.inject.Inject

import play.api.Logger
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class ExampleAction @Inject() (parser: BodyParsers.Default)(implicit ec: ExecutionContext) extends ActionBuilderImpl(parser) {
  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    Logger.info(s"${getClass.getName} ${request.path}")
    block(request)
  }
}
