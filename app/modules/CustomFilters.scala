package modules

import javax.inject.Inject

import play.api.http.HttpFilters
import play.api.mvc.EssentialFilter
import play.filters.csrf.CSRFFilter

/**
  * Provides filters.
  */
class CustomFilters @Inject() (csrfFilter: CSRFFilter, loggingFilter: LoggingFilter) extends HttpFilters {
  override def filters: Seq[EssentialFilter] = Seq(csrfFilter, loggingFilter)
}
