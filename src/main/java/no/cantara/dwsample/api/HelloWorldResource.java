package no.cantara.dwsample.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path(HelloWorldResource.PATH)
@Api(HelloWorldResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
public interface HelloWorldResource {

    public static final String PATH = "/";
    public static final String QUERY_PARAM_GET_HELLO_NAME = "name";

    public static final String PATH_SPECIFIC_PLANET = "/planet";
    public static final String PATH_PARAM_GET_SPECIFIC_PLANET_ID = "id";

    @GET
    @ApiOperation("Endpoint that will respond with hello and use the name provided as request parameter if any")
    Saying hello(@QueryParam(QUERY_PARAM_GET_HELLO_NAME) @ApiParam(defaultValue = "Mr. Smith") Optional<String> name);

    @POST
    @ApiOperation("Post planetName and yourName and be greeted.")
    @Consumes(MediaType.APPLICATION_JSON)
    Saying hello(Planet planet);

    @GET
    @Path(HelloWorldResource.PATH_SPECIFIC_PLANET + "/{" + PATH_PARAM_GET_SPECIFIC_PLANET_ID + "}")
    @ApiOperation("Endpoint that will respond with hello from a specific planet id.")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    SpecificPlanet helloSpecificPlanet(@PathParam(PATH_PARAM_GET_SPECIFIC_PLANET_ID) @ApiParam String id);
}