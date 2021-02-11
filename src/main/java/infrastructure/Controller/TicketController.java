package infrastructure.Controller;

import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import domain.models.UserNotFoundException;
import use_case.Client.SendConfirmTicket;
import use_case.Client.UpdateTicketAnswer;

import java.util.List;

@RestController
public class TicketController {


    private final UpdateTicketAnswer updateTicketAnswer;
    private final SendConfirmTicket sendConfirmTicket;


    public TicketController(UpdateTicketAnswer updateTicketAnswer, SendConfirmTicket sendConfirmTicket) {
        this.updateTicketAnswer = updateTicketAnswer;
        this.sendConfirmTicket = sendConfirmTicket;
    }

    @PostMapping("/ticket/update")
    public void updateTicketChoice(List<Ticket> tickets){
        try{
            updateTicketAnswer.execute(tickets);
        }catch(InvalidAnswerException e){
            //LOGGER.LOG(e)
        }catch(UserNotFoundException e){
            //LOGGER.LOG(e)
        }
    }

    public void setTicketList(List<Ticket> ticketList){

    }
}
