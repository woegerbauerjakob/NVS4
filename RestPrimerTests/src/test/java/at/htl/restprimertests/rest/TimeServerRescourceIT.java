package at.htl.restprimertests.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeServerRescourceIT {
    private Client client;
    private WebTarget tut;

    @BeforeEach
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/restprimer/api/time");
    }

    @Test
    public void fetchTime(){
        Response response = this.tut.request(MediaType.TEXT_PLAIN).get();
        assertThat(response.getStatus(),is(200));
        String payload = response.readEntity(String.class);
        assertTrue(payload.startsWith("Time: "));
    }
}
