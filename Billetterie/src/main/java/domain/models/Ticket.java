package domain.models;


public class Ticket {

    int id;
    int price;
    int user_id;
    String answer;
    String time;

    public Ticket(int id, int price, int user_id,String time) {
        this.id = id;
        this.price = price;
        this.user_id = user_id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void update(String answer) throws InvalidAnswerException{
        this.answer = answer;
        checkAnswer();
    }

    public void checkAnswer() throws InvalidAnswerException{
        if(!(answer.equals("KEEP") || answer.equals("REIMBURSE") || answer.equals("UNDEFINED"))){
            throw new InvalidAnswerException();
        }
    }


}
