package armen.springbootmillionaires.service;

import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.repositories.QuestionRepository;
import armen.springbootmillionaires.util.QuestionForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private QuestionService questionService;

    private List<Integer> randomQuestionNumbers;

    private boolean use50_50;

    Random random = new Random();

    @Override
    public boolean addQuestion(Questions questions) {
        questionService.saveToDB(questions);
        return true;
    }

    @Override
    public void initOrReset() {
        randomQuestionNumbers = new ArrayList<>();
        use50_50 = false;

    }

    @Override
    public Questions getRandomQuestion(int maxElement) {
        int id;
        boolean state;
        while (true) {
            id = random.nextInt(maxElement - 1) + 1;
            state = false;
            for (int k : randomQuestionNumbers) {
                if (id == k) {
                    state = true;
                    break;
                }

            }
            if (!state) {
                break;
            }

        }
        log.info("id = {}", id);
        randomQuestionNumbers.add(id);
        return questionService.getFromDBById(id);
    }

    @Override
    public QuestionForm readQuestion(int id) {
        return null;
    }

    @Override
    public Questions make50_50(Questions questions) {
        int id;
        boolean state;
        while (true) {
            id = random.nextInt(3) + 1;

            if (id != questions.getRightAnswer()) {
                break;
            }

        }

        for (int i = 1; i < 5; i++) {
            if (!(i == questions.getRightAnswer() || i == id)) {
               switch (i) {
                    case 1:
                        questions.setAnswer_1("_________");
                        break;
                    case 2:
                        questions.setAnswer_2("_________");
                        break;
                    case 3:
                        questions.setAnswer_3("_________");
                        break;
                    case 4:
                        questions.setAnswer_4("_________");
                        break;

                }
            }

        }


        return questions;
    }

    @Override
    public boolean chackQuestion(QuestionForm questionForm, int answer) {
        return false;
    }

    @Override
    public int questionsLength() {
        return 0;
    }

    @Override
    public int generatRandomNumber() {
        return 0;
    }
}
