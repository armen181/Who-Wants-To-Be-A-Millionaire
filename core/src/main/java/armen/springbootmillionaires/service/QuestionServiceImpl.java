package armen.springbootmillionaires.service;


import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.repositories.QuestionRepository;
import armen.springbootmillionaires.util.QuestionForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {

       this.questionRepository = questionRepository;

    }

    @Override
    public Questions saveToDB(Questions questions) {
        log.info("write to db from questionServiceImpl");
        questionRepository.save(questions);
        return questions;
    }

    @Override
    public Questions getFromDBById(int id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public List<QuestionForm> ListAll(Questions questionsLevel1) {
        return null;
    }
}
