package armen.springbootmillionaires.service;

import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.util.QuestionForm;

public interface GameService {

    boolean addQuestion(Questions questions);

    void initOrReset();


    Questions getRandomQuestion(int maxElement);


    QuestionForm readQuestion(int id);

    Questions make50_50(Questions questions);

    boolean chackQuestion(QuestionForm questionForm, int answer);

    int questionsLength();

    int generatRandomNumber();

}
