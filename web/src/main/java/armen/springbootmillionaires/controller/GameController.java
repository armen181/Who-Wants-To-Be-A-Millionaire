package armen.springbootmillionaires.controller;




import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.service.GameService;
import armen.springbootmillionaires.service.MessageService;
import armen.springbootmillionaires.util.QuestionArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GameController {


  // == field ==

  public static final String START_MESSAGE = "start.msg";
  public static final String GAME_DESKRP = "game.deskrp";
  public static final String RIGHT_ANSWER = "right.answer";
  public static final String WRONG_ANSWER = "wrong.answer";
  public static final String WIN_MONEY = "win.money";
  public static final String LOSE_GAME = "lose.game";
  public static final String GAME_OVER= "game.over";
  public static final String PLAY_AGAIN = "play.again";

  private GameService gameService;

  private QuestionArray questionArray;

  private MessageService messageService;


  private boolean status = false;
  private boolean use50_50 = false;
  private Questions newQuestion;

  // == constructor ==

  @Autowired
  public GameController(GameService gameService, QuestionArray questionArray, MessageService messageService) {
    this.gameService = gameService;
    this.questionArray = questionArray;
    this.messageService = messageService;
  }


  // === RQ ===
  @GetMapping("startGame")
    public Questions getQuestion(){
    for(Questions questions : questionArray.getQuestionsArray()) {
      gameService.addQuestion(questions);
    }
    gameService.initOrReset();
    status = false;
    use50_50 = false;
    newQuestion = messageService.getNextMessage();
    return newQuestion;

  }

  @PostMapping("answer")
  public Questions chackAnswer(@RequestHeader int answer) {
    int status = messageService.getResultMessage(newQuestion, answer);

    if (status == 1) {
      newQuestion.setQuestionId("true");
      return newQuestion;
    } else if (status == 0) {
      newQuestion= gameService.make50_50(newQuestion);
      return newQuestion;
    } else {
      newQuestion.setQuestionId("false");
      return newQuestion;
    }
  }

}
