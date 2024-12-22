package in.oss.laminar.components

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom
import frontroute.*
import org.scalajs.dom.HTMLDivElement

import scala.scalajs.js
import scala.scalajs.js.annotation.*

object Header {

  def apply(): ReactiveHtmlElement[HTMLDivElement] =
    div(
      cls := "container-fluid p-0",
      div(
        div(
          cls := "container",
          navTag(
            cls := "navbar navbar-expand-lg navbar-light",
            div(
              cls := "container",
              renderLogo(),
              button(
                cls                                         := "navbar-toggler",
                `type`                                      := "button",
                htmlAttr("data-bs-toggle", StringAsIsCodec) := "collapse",
                htmlAttr("data-bs-target", StringAsIsCodec) := "#navbarNav",
                htmlAttr("aria-controls", StringAsIsCodec)  := "navbarNav",
                htmlAttr("aria-expanded", StringAsIsCodec)  := "false",
                htmlAttr("aria-label", StringAsIsCodec)     := "Toggle navigation",
                span(cls := "navbar-toggler-icon")
              ),
              div(
                cls    := "collapse navbar-collapse",
                idAttr := "navbarNav",
                ul(
                  cls := "navbar-nav ms-auto menu align-center expanded text-center SMN_effect-3",
                  renderNavLinks()
                )
              )
            )
          )
        )
      )
    )

  @js.native
  @JSImport("/static/img/konoha-leaf-logo.jpg", JSImport.Default)
  private def logoImage: String = js.native
  // To map a Scala String to Javascript, you need to use 'js.native', '@js.native' and '@JSImport'

  private def renderLogo() =
    a(
      href := "/",
      cls  := "navbar-brand",
      img(
        src    := logoImage,
        alt    := "App Logo",
        width  := "50",
        height := "50"
      )
    )

  private def renderNavLinks() = List(
    renderNavLink("Companies", "/companies"),
    renderNavLink("Log In", "/login"),
    renderNavLink("Sign Up", "/signup")
  )

  private def renderNavLink(text: String, location: String) =
    li(
      cls := "nav-item",
      Anchors.renderNavLink(text, location, "")
    )

}
