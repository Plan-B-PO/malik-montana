package pln.malik.montana.healthcheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Controller
public class UserApplicationController {

  RouterFunction<ServerResponse> route = RouterFunctions.route()
    .POST("/info", (request -> null)).build();
}
