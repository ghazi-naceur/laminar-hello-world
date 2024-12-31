package in.oss.laminar.pages

import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import in.oss.laminar.components.Anchors
import in.oss.laminar.model.Company
import org.scalajs.dom.{HTMLDivElement, HTMLElement}

import scala.scalajs.js.annotation.*
import scala.scalajs.js

object CompaniesPage {

  def dummyCompany = Company(
    id = 1L,
    slug = "slug-company",
    name = "Company name",
    url = "https://google.com",
    location = Some("Here"),
    country = Some("Somewhere"),
    industry = Some("Industry"),
    image = None,
    tags = List("tag1", "tag2")
  )

  def performBackendCall():Unit = {
    //Backend calls can be performed:
//    1-  in Laminar explicitly by using the 'fetch' API
//    2-  using 'Ajax' calls
//    3-  using sttp: basicRequest/FetchBackend
  }

  def apply(): ReactiveHtmlElement[HTMLElement] =
    sectionTag(
      onMountCallback(_ => performBackendCall()),// 'onMountCallback' will allow us to perform any sort of 'Unit' returning functions, when the
      // section tag is added into the HTML.
      cls := "section-1",
      div(
        h1("Companies Board")
      ),
      div(
        cls := "container",
        div(
          div(
            cls := "col-lg-4",
            div("TODO filter panel here")
          ),
          div(
            cls := "col-lg-8",
            sketchCompany(dummyCompany),
            sketchCompany(dummyCompany)
          )
        )
      )
    )

  def sketchCompany(company: Company) =
    div(
      div(
        renderCompanyLogo(company)
      ),
      div(
        h5(
          Anchors.renderNavLink(
            company.name,
            s"/company/${company.id}",
            "company-title-link"
          )
        ),
        renderOverview(company)
      ),
      renderAction(company)
    )

  @js.native
  @JSImport("/static/img/briefcase.png", JSImport.Default)
  private val missingCompanyLogo: String = js.native

  private def renderCompanyLogo(company: Company) =
    img(
      cls := "img-fluid",
      src := company.image.getOrElse(missingCompanyLogo),
      alt := company.name
    )

  private def renderOverview(company: Company) =
    div(
      div(
        i(cls := s"fa fa-location-dot"),
        p(fullLocation(company))
      ),
      div(
        i(cls := s"fa fa-tags"),
        p(company.tags.mkString(", "))
      )
    )

  private def fullLocation(company: Company): String =
    (company.location, company.country) match {
      case (Some(location), Some(country)) => s"$location, $country"
      case (Some(location), None)          => s"$location"
      case (None, Some(country))           => s"$country"
      case (None, None)                    => "Anywhere"
    }

  private def renderAction(company: Company) =
    div(
      a(
        href   := company.url,
        target := "blank",
        button(
          `type` := "button",
          cls    := "btn btn-danger rock-action-btn",
          "Website"
        )
      )
    )
}
