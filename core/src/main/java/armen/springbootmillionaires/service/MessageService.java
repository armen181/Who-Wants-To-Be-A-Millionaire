package armen.springbootmillionaires.service;

import armen.springbootmillionaires.DB.Questions;

public interface MessageService {
    String getTextMessage(String value);
    String getTextMessage(String value, int money);
    int getResultMessage(Questions questions, int answer);
    Questions getNextMessage();

}
