package armen.springbootmillionaires.service;


import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.util.QuestionForm;

import java.util.List;

public interface QuestionService {

    Questions saveToDB(Questions questions);

    List<QuestionForm> ListAll(Questions questionsLevel1);

    Questions getFromDBById(int id);


}
