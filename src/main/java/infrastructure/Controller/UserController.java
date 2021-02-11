package infrastructure.Controller;

import domain.models.InvalidAnswerException;
import use_case.Service_client.DeleteUserChoice;
import use_case.Service_client.GetUserChoice;

@RestController
public class UserController {

    private final DeleteUserChoice deleteUserChoice;
    private final GetUserChoice getUserChoice;

    public UserController(DeleteUserChoice deleteUserChoice,GetUserChoice getUserChoice){
        this.deleteUserChoice = deleteUserChoice;
        this.getUserChoice = getUserChoice;
    }

    @RequestMapping("/user/choice/delete")
    public void deleteAllUserChoice (){
        try{
            deleteUserChoice.execute();
        }catch(InvalidAnswerException e){
            //LOGGER.LOG(e)
        }
    }

    @RequestMapping("/user/choice/get")
    public void getAllUserChoice(){
        getUserChoice.execute();

    }


}
