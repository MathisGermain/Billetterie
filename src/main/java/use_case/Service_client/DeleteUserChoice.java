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

    public void execute() throws InvalidAnswerException {
        final List<Ticket> tickets = ticketRepository.getAllChosenTickets();

        for(Ticket ticket : tickets){
            ticketRepository.updateTicket(ticket.getId(),"UNDEFINED");
        }
    }




}
