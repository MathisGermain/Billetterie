package utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.models.Ticket;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonFileTicketDAO {


    private static String convertInputStreamToStringJDK9(InputStream inputStream)throws IOException {
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    private List<Ticket> loadTickets(String jsonFilePath) {

        List<Ticket> ticketList = null;

        try {
            JSONObject jsonObject = new JSONObject(convertInputStreamToStringJDK9(this.getClass().getClassLoader().getResourceAsStream(jsonFilePath)));
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            ticketList = mapper.readValue(jsonObject.toString(),  new TypeReference<List<Ticket>>(){});
        } catch (JSONException e2) {
            //LOG
        } catch (IOException e){
            //LOG
        }
        return ticketList;
    }


}
