package example.serverSystem.services;

import com.google.gson.JsonObject;
import example.serverSystem.WeatherStation;
import example.serverSystem.WeatherStationDriver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/estacoes")
public class WeatherStationService {
	//region vars
	private WeatherStationDriver weatherStation;
	//endregion

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello(@PathParam("name") String msg) {
        String output = "Hello, " + msg + "!";
        return Response.status(200).entity(output).build();
    }

    public  void main(String[] args) {

//        try {
//
//            Client client = Client.create();
//
//            WebResource webResource = client
//                    .resource("http://localhost:8080/JavaCloudantApp/rest/estacoes");
//
//            ClientResponse response = webResource.accept("application/json")
//                    .get(ClientResponse.class);
//
//            if (response.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + response.getStatus());
//            }
//
//            String output = response.getEntity(String.class);
//
//            System.out.println("Output from Server .... \n");
//            System.out.println(output);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }

    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getWeatherStation() throws IOException {
		this.weatherStation = new WeatherStationDriver(22,true, "55");
		JsonObject result = this.weatherStation.ws.getWeatherStation();
		return result;
	}

}
