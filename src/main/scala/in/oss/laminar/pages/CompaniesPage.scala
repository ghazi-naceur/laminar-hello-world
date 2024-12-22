package in.oss.laminar.pages

import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement

object CompaniesPage {

  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div("main page")
}
