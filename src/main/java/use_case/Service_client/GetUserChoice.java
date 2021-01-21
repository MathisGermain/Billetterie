package use_case.Service_client;

import domain.TicketRepository;
import domain.models.Ticket;
import domain.models.User;

import java.util.List;

public class GetUserChoice {

    private final TicketRepository ticketRepository;

    public GetUserChoice(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /*public List<Ticket> getChoices(User user){
        return this.ticketRepository.getTickets(user);

    }*/

    public List<Ticket> getAllChoices(){
        return this.ticketRepository.getAllChosenTickets();
    }
}
