package infrastructure.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.TicketRepository;
import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import domain.models.TicketNotFoundException;
import domain.models.User;

import java.util.HashMap;
import java.util.List;

public class InMemoryTicket implements TicketRepository {


    private List<Ticket> tickets = null;

        //ObjectMapper objectMapper = new ObjectMapper();
        //this.tickets = objectMapper.readValue(json, new TypeReference<HashMap<String, String>>(){});



    public List<Ticket> getTickets(User user) {
        List<Ticket> userTickets = null;
        for(int x = 0 ; x < this.tickets.size() ; x++){
            if(user.getId() == this.tickets.get(x).getUser_id()){
                userTickets.add(this.tickets.get(x));
            }
        }
        return userTickets;
    }

    public List<Ticket> getAllChosenTickets() {
        List<Ticket> chosenTickets = null;
        for(int x = 0 ; x < this.tickets.size() ; x++){
            if(!this.tickets.get(x).getAnswer().equals("UNDEFINED")){
                chosenTickets.add(this.tickets.get(x));
            }
        }
        return chosenTickets;
    }

    public Ticket getTicketById(int ticketId) throws TicketNotFoundException {
        for(int x = 0 ; x < this.tickets.size() ; x++){
            if(this.tickets.get(x).getId() == ticketId){
                return this.tickets.get(x);
            }
        }
        throw new TicketNotFoundException();
    }

    public void updateTicket(int ticketId, String answer) throws InvalidAnswerException {
        for(int x = 0 ; x < this.tickets.size() ; x++){
            if(this.tickets.get(x).getId() == ticketId){
                this.tickets.get(x).update(answer);
            }
        }
    }




}
