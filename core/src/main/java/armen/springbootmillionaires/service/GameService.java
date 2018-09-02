package armen.springbootmillionaires.service;

import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.util.QuestionForm;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

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
