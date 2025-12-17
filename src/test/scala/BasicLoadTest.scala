package

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicLoadTest extends Simulation {

  val httpProtocol = http
    .baseUrl("http://example.com")
    .acceptHeader("text/html,application/xhtml+xml")
    .userAgentHeader("Mozilla/5.0")

  val scn = scenario("Basic Load Test")
    .exec(
      http("request_1")
        .get("/")
        .check(status.is(200))
    )
    .pause(1)
    .exec(
      http("request_2")
        .get("/about")
        .check(status.is(200))
    )

  setUp(
    scn.inject(
      rampUsers(100).during(10.seconds),
      constantUsersPerSec(50).during(30.seconds),
      rampDown(10).during(5.seconds)
    )
  ).protocols(httpProtocol)
   .assertions(
      global.responseTime.max.lt(5000),
      global.successfulRequests.percent.gt(95)
    )
}
