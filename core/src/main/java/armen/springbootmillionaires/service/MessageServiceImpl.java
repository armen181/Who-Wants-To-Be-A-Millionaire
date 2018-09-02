package armen.springbootmillionaires.service;

import armen.springbootmillionaires.DB.Questions;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MessageServiceImpl implements MessageService{



private GameService gameService;
private MessageSource messageSource;

    public MessageServiceImpl(GameService gameService, MessageSource messageSource) {
        this.gameService = gameService;
        this.messageSource = messageSource;
    }

    @Override
    public String getTextMessage(String value) {
        return getMessage(value);
    }

    @Override
    public String getTextMessage(String value, int money) {
        return getMessage(value,money);
    }

    @Override
    public int getResultMessage(Questions questions, int answer) {
        if(questions.getRightAnswer()==answer) {

            return 1;
        }else if(answer == 50) {
            return 0;
        }else {
            return -1;
        }


    }

    @Override
    public Questions getNextMessage() {
       return gameService.getRandomQuestion( 9);
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
