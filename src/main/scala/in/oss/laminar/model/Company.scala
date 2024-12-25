package in.oss.laminar.model

case class Company(
    id: Long,
    slug: String,
    name: String,
    url: String,
    location: Option[String],
    country: Option[String],
    industry: Option[String],
    image: Option[String],
    tags: List[String]
)
