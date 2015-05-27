# play-json-extra

[![Build Status](https://secure.travis-ci.org/xuwei-k/play-json-extra.png)](http://travis-ci.org/xuwei-k/play-json-extra)


- [Maven Central Repository Search](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.xuwei-k%22%20AND%20a%3A%22play-json-extra_2.11%22)
- [Maven Central](http://repo1.maven.org/maven2/com/github/xuwei-k/play-json-extra_2.11/)

### motivation and example

I think following way is so verbose.

```scala
import play.api.libs.json._
import play.api.libs.functional.syntax._

final case class User(id: Long, name: String)

object User {
  implicit val format: OFormat[User] = (
    (__ \ "id").format[Long] and // I want to omit `Long` and `String`
    (__ \ "name").format[String]
  )(apply _, Function.unlift(unapply))
}
```

[Play provides Json macros](https://www.playframework.com/documentation/2.4.x/ScalaJsonInception). Yes it is useful, but I want to **specify Json keys explicitly** sometime like [argonaut casecodecN](https://github.com/argonaut-io/argonaut/blob/v6.1/src/test/scala/argonaut/example/JsonExample.scala#L27)

```scala
import play.api.libs.json._
import play.jsonext._

final case class User(id: Long, name: String)

object User {
  implicit val format: OFormat[User] =
    CaseClassFormats(apply _, unapply _)("id", "name")
}
```

### latest stable version for play2.4

```scala
libraryDependencies += "com.github.xuwei-k" %% "play-json-extra" % "0.3.0"
```

- [API Documentation](https://oss.sonatype.org/service/local/repositories/releases/archive/com/github/xuwei-k/play-json-extra_2.10/0.3.0/play-json-extra_2.10-0.3.0-javadoc.jar/!/index.html)

### snapshot version for play2.4

```scala
resolvers += Opts.resolver.sonatypeSnapshots

libraryDependencies += "com.github.xuwei-k" %% "play-json-extra" % "0.3.1-SNAPSHOT"
```

- [API Documentation](https://oss.sonatype.org/service/local/repositories/snapshots/archive/com/github/xuwei-k/play-json-extra_2.10/0.3.1-SNAPSHOT/play-json-extra_2.10-0.3.1-SNAPSHOT-javadoc.jar/!/index.html)


