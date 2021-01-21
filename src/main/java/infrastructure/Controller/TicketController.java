package infrastructure.Controller;

import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import domain.models.UserNotFoundException;
import use_case.Client.SendConfirmTicket;
import use_case.Client.UpdateTicketAnswer;

import java.util.List;

public class TicketController {


    private final UpdateTicketAnswer updateTicketAnswer;
    private final SendConfirmTicket sendConfirmTicket;

    public TicketController(UpdateTicketAnswer updateTicketAnswer, SendConfirmTicket sendConfirmTicket) {
        this.updateTicketAnswer = updateTicketAnswer;
        this.sendConfirmTicket = sendConfirmTicket;
    }

    public void updateTicketChoice(List<Ticket> tickets){
        try{
            updateTicketAnswer.update(tickets);
            sendConfirmTicket.sendEmail(tickets.get(0).getUser_id());
        }catch(InvalidAnswerException e){
            //LOGGER.LOG(e)
        }catch(UserNotFoundException e){
            //LOGGER.LOG(e)
        }
    }
}
