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
        for(Ticket ticket : tickets){
            if(user.getId() == ticket.getUser_id()){
                userTickets.add(ticket);
            }
        }
        return userTickets;
    }

    public List<Ticket> getAllChosenTickets() {
        List<Ticket> chosenTickets = null;
        for(Ticket ticket : tickets){
            if(!ticket.getAnswer().equals("UNDEFINED")){
                chosenTickets.add(ticket);
            }
        }
        return chosenTickets;
    }

    public Ticket getTicketById(int ticketId) throws TicketNotFoundException {
        for(Ticket ticket : tickets){
            if(ticket.getId() == ticketId){
                return ticket;
            }
        }
        throw new TicketNotFoundException();
    }

    public void updateTicket(int ticketId, String answer) throws InvalidAnswerException {
        for(Ticket ticket : tickets){
            if(ticket.getId() == ticketId){
                ticket.update(answer);
            }
        }
    }




}
