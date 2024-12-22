package in.oss.laminar.components

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom
import frontroute.*
import in.oss.laminar.pages.*
import org.scalajs.dom.HTMLElement

object Router {

  def apply(): ReactiveHtmlElement[HTMLElement] =
    mainTag( // renders as <main>
      routes(
        div(
          cls := "container-fluid",
          (pathEnd | path("companies")) { // represents localhost:1234 or localhost:1234/ or localhost:1234/companies
            CompaniesPage()
          },
          path("login") { // represents localhost:1234/login
            LoginPage()
          },
          path("signup") { // represents localhost:1234/signup
            SignupPage()
          },
          noneMatched {
            NotFoundPage()
          }
        )
      )
    )
}
