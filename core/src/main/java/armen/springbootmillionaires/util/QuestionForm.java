package armen.springbootmillionaires.util;

import armen.springbootmillionaires.DB.Questions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

    private String question;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private int rightAnswer;
    private String questionId;

    public QuestionForm(String question, String answer_1, String answer_2, String answer_3, String answer_4, int rightAnswer, String questionId) {
        this.question = question;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
        this.rightAnswer = rightAnswer;
        this.questionId = questionId;
    }
}
