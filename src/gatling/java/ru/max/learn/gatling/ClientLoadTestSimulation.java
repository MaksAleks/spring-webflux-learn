package ru.max.learn.gatling;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.repeat;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class ClientLoadTestSimulation extends Simulation { // 3

    HttpProtocolBuilder httpProtocol = http // 4
            .baseUrl("http://localhost:8080/") // 5
            .acceptHeader("application/json"); // 6

    ChainBuilder cb = repeat(100).on(exec(http("request_1")
            .get("/client")));
    ScenarioBuilder scn = scenario("ru.max.learn.gatling.ClientLoadTest")
            .exec(cb);

    {
        setUp( // 11
                scn.injectOpen(rampUsers(1000).during(10)) // 12
        ).protocols(httpProtocol); // 13
    }
}