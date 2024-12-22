package in.oss.laminar.pages

import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLDivElement

object LoginPage {

  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div("login page")
}
