package armen.springbootmillionaires;

import armen.springbootmillionaires.DB.Questions;
import armen.springbootmillionaires.service.GameService;
import armen.springbootmillionaires.service.MessageService;
import armen.springbootmillionaires.util.QuestionArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Slf4j
@Component
public class ConsolePlay {

@Autowired
private GameService gameService;
@Autowired
private QuestionArray questionArray;
@Autowired
private MessageService messageService;


    public static final String START_MESSAGE = "start.msg";
    public static final String GAME_DESKRP = "game.deskrp";
    public static final String RIGHT_ANSWER = "right.answer";
    public static final String WRONG_ANSWER = "wrong.answer";
    public static final String WIN_MONEY = "win.money";
    public static final String LOSE_GAME = "lose.game";
    public static final String GAME_OVER= "game.over";
    public static final String PLAY_AGAIN = "play.again";

    private void moneyWin(int in){
        switch (in){
            case 0:
                System.out.println(messageService.getTextMessage(WIN_MONEY,0));
                break;
            case 1:
                System.out.println(messageService.getTextMessage(WIN_MONEY,20000));
                break;
            case 2:
                System.out.println(messageService.getTextMessage(WIN_MONEY,50000));
                break;
            case 3:
                System.out.println(messageService.getTextMessage(WIN_MONEY,100000));
                break;
            case 4:
                System.out.println(messageService.getTextMessage(WIN_MONEY,200000));
                break;
            case 5:
                System.out.println(messageService.getTextMessage(WIN_MONEY,500000));
                break;
            case 6:
                System.out.println(messageService.getTextMessage(WIN_MONEY,1000000));
                break;
        }
    }


    @EventListener
    public void start (ContextRefreshedEvent contextRefreshedEvent){
        log.info("Start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);
        for(Questions questions : questionArray.getQuestionsArray()) {
            gameService.addQuestion(questions);
        }

        System.out.println(messageService.getTextMessage(START_MESSAGE));
        System.out.println("Ամեն հարցից հետո կարող եք վերցնել գումարը կամ շարունակել խաղալ։");
        System.out.println("Առային հարցին ճիշտ պատասխանելու դեպքում կստանաք 20000 դրամ");
        System.out.println("Երկրորդ հարցին ճիշտ պատասխանելու դեպքում կստանաք 50000 դրամ");
        System.out.println("Երրորդ հարցին ճիշտ պատասխանելու դեպքում կստանաք 100000 դրամ");
        System.out.println("Չորրորդ հարցին ճիշտ պատասխանելու դեպքում կստանաք 200000 դրամ");
        System.out.println("Հինգերորդ հարցին ճիշտ պատասխանելու դեպքում կստանաք 500000 դրամ");
        System.out.println("Վոցերորդ հարցին ճիշտ պատասխանելու դեպքում կստանաք 1000000 դրամ");
        System.out.println("================== Խաղը սկսված է ========================");
        int questionNumber = 1;
        gameService.initOrReset();
        boolean status = false;
        boolean use50_50 = false;
        Questions newQuestion = messageService.getNextMessage();
        while (true){

            System.out.println("Հարց համար " + questionNumber);

            System.out.println(newQuestion.getQuestion());
            System.out.println();
            System.out.println("1__-__"+ newQuestion.getAnswer_1()+ "_________2__-__" + newQuestion.getAnswer_2());
            System.out.println();
            System.out.println("3__-__"+ newQuestion.getAnswer_3()+ "_________4__-__" + newQuestion.getAnswer_4());
             if(!use50_50){
                 System.out.println("Դուք կարող եք օգտագործել 50-50 օգնության հնարավորությունը պատասխանելով <<50>> ");
             }


            int yourSet = scanner.nextInt();
             if(messageService.getResultMessage(newQuestion,yourSet)==-1){
                 System.out.println(messageService.getTextMessage(WRONG_ANSWER));
                 System.out.println(messageService.getTextMessage(GAME_OVER));
                 moneyWin(0);
                 System.out.println(messageService.getTextMessage(PLAY_AGAIN));
                 int playAg = scanner.nextInt();
                 if(playAg==1){
                     gameService.initOrReset();
                     questionNumber = 0;
                     System.out.println("================== Խաղը սկսված է ========================");
                 }else {

                     status = true;
                 }

             }else if(messageService.getResultMessage(newQuestion,yourSet) == 0){
                 System.out.println("Դուք օգտագործեցիք 50-50 օգնության հնարավորությունը։");
                 newQuestion= gameService.make50_50(newQuestion);
                 use50_50=true;

             } else {
                 System.out.println(messageService.getTextMessage(RIGHT_ANSWER));

                 System.out.println("Ցանկանում էք շարունակել թե վերցնում էք գումարը 1։այո/2։ոչ");
                 int contin = scanner.nextInt();
                 if(contin==1){
                     moneyWin(questionNumber);
                 }else {
                     System.out.println(messageService.getTextMessage(GAME_OVER));
                     moneyWin(questionNumber);
                     System.out.println(messageService.getTextMessage(PLAY_AGAIN));
                     int playAgain = scanner.nextInt();
                     if(playAgain==1){
                         gameService.initOrReset();
                         questionNumber = 0;
                         System.out.println("================== Խաղը սկսված է ========================");
                     }else {

                         status = true;
                     }

                 }


                 if(status){
                     break;
                 }
                 questionNumber++;
                 newQuestion = messageService.getNextMessage();

             }



         }



   }


}
