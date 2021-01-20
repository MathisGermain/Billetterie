package use_case.Client;

import domain.TicketRepository;
import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import domain.models.TicketNotFoundException;

public class UpdateTicketAnswer {

    private final TicketRepository ticketRepository;

    public UpdateTicketAnswer(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void update(String answer, int ticketId) throws InvalidAnswerException, TicketNotFoundException {
        if(answer.equals("KEEP") || answer.equals("REIMBURSE")){
            this.ticketRepository.updateTicket(ticketId,answer);
        }
    }

}
