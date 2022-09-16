package com.api.localhost

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class APITest extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val scn = scenario("APITest")
    .exec(
      http("request_0")
        .get("/history")
    )

  setUp(scn.inject(atOnceUsers(15000))).protocols(httpProtocol)
}
