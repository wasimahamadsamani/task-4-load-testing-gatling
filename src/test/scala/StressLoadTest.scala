package

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class StressLoadTest extends Simulation {

  val httpProtocol = http
    .baseUrl("http://example.com")
    .acceptHeader("text/html,application/xhtml+xml")
    .userAgentHeader("Mozilla/5.0")

  val scn = scenario("Stress Test")
    .exec(
      http("heavy_request_1")
        .get("/api/data")
        .check(status.is(200))
    )
    .pause(500.milliseconds)
    .exec(
      http("heavy_request_2")
        .get("/api/process")
        .check(status.is(200))
    )
    .pause(500.milliseconds)
    .exec(
      http("heavy_request_3")
        .post("/api/submit")
        .body(StringBody("{\"data\":\"test\"}")),
        .check(status.is(201))
    )

  setUp(
    scn.inject(
      rampUsers(500).during(5.seconds),
      constantUsersPerSec(200).during(60.seconds),
      rampDown(100).during(10.seconds)
    )
  ).protocols(httpProtocol)
   .assertions(
      global.responseTime.percentile(95).lt(10000),
      global.successfulRequests.percent.gt(90),
      forAllRequests.responseTime.max.lt(30000)
    )
}
