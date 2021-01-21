package use_case.Client;

import domain.TicketRepository;
import domain.models.InvalidAnswerException;
import domain.models.Ticket;

import java.util.List;

public class UpdateTicketAnswer {

    private final TicketRepository ticketRepository;

    public UpdateTicketAnswer(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void update(List<Ticket> tickets) throws InvalidAnswerException {
        for(Ticket ticket : tickets){
            this.ticketRepository.updateTicket(ticket.getId(),ticket.getAnswer());
        }
    }

}
