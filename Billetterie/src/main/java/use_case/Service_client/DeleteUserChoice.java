package use_case.Service_client;

import domain.TicketRepository;
import domain.models.InvalidAnswerException;
import domain.models.Ticket;

import java.util.List;

public class DeleteUserChoice {

    private final TicketRepository ticketRepository;

    public DeleteUserChoice(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void deleteAllChoices() throws InvalidAnswerException {
        final List<Ticket> tickets = ticketRepository.getAllChosenTickets();

        // A remplacer
        for(int x = 0 ; x < tickets.size() ; x++){
            ticketRepository.updateTicket(tickets.get(x).getId(),"undefined");
        }
    }




}
