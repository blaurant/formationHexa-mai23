package infrastructure.rest;

import application.BdService;
import application.EnregistrementBdCmd;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class BdRest extends AbstractVerticle {

    private final int port;

    BdService bdService;
    BdAdaptor bdAdaptor;

    public BdRest(Vertx vertx, int port, BdService bdService) {
        this.vertx = vertx;
        this.port = port;
        this.bdService = bdService;
        this.bdAdaptor = new BdAdaptor(bdService);
    }

    // end point
    public void start() {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.post("/bds/:bdId")
                .respond(ctx -> Future.succeededFuture(enregistrerBDHandler(ctx)));
        server.requestHandler(router).listen(port);
    }

    private Object enregistrerBDHandler(RoutingContext ctx) {
        EnregistrementBdCmd enregistrementBdCmd = adapt(ctx);
        enregistrementBdCmd.run();
        ctx.response().setStatusCode(201);
        return "created";
    }

    private EnregistrementBdCmd adapt(RoutingContext ctx) {
        String idStr = ctx.pathParam("bdId");
        EnregistrementBdDto enregistrementBdDto = Json.decodeValue(ctx.body().asString(), EnregistrementBdDto.class);
        return bdAdaptor.adapt(idStr, enregistrementBdDto);
    }

}
