package armen.springbootmillionaires.util;

import armen.springbootmillionaires.DB.Questions;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class QuestionArray {


    public List<Questions> getQuestionsArray(){
    List<Questions> list = new ArrayList<>();
    Questions questions = new Questions(
            "Ո՞ր կրոնին է պատկանում Զենի փիլիսոփայությունը:",
            "Բուդիզմ",
            "Հուդաիզմ",
            "Հինդուիզմ",
            "Տաոիզմ",
            1,
            "__0"
    );
        list.add(questions);
                questions = new Questions(
                "Ո՞ր քաղաքում է տեղի ունեցել 1932 թ. Ֆիլմերի փառատոնը:",
                "Կանն",
                "Վենետիկ",
                "Բեռլին",
                "Մոսկվա",
                2,
                "__1"
                );
                list.add(questions);
                questions = new Questions(
                "Ո՞վ է ստացել առաջին նոբելյան մրցանակը գրականությունից:",
                "Թատերագիր",
                "Վիպասան",
                "Էսսեյագիր",
                "Բանաստեղծ",
                4,
                "__2"
                );
                list.add(questions);
                questions = new Questions(
                "Ո՞ր քիմիական տարրն է անվանվել «գետնի տակ ապրող չար թզուկի» պատվին:",
                "Կոբալտ",
                "Տելուր",
                "Բերիլիում",
                "Հաֆնիում",
                1,
                "__3"
                );
                list.add(questions);
                questions = new Questions(
                "Հին Հունաստանում կանանց չէր թույլատրվում մասնակցել Օլիմպիական խաղերին, բացի այս սպորտաձևից: Ո՞րն էր դա:",
                "Վազք",
                "Ըմբշամարտ",
                "Կառքով մրցույթ",
                "Լող",
                3,
                "__4"
                );
                list.add(questions);
                questions = new Questions(
                "Քանի՞ ծովեր են ողողում Բալկանները:",
                "4",
                "6",
                "3",
                "5",
                2,
                "__5"
                );
                list.add(questions);
                questions = new Questions(
                "Անդրոիդ օպերացիոն համակարգի բոլոր նորացված տարբերակներում պարտադիր պայմանով ի՞նչ բառեր են օգտագործվում:",
                "Բուն ամերիկյան անուն",
                "Ծովի անվանում",
                "Քաղցավենիքի անվանում",
                "Եղանակի անվանում",
                3,
                "__6"
                );
                list.add(questions);
                questions = new Questions(
                "Ո՞ր կղզին է կոչվել հոլանդացի հայտնի ծովագնացի անունով:",
                "Սումատրա",
                "Տասմանիա",
                "Կալիմանտան",
                "Մադագասկար",
                2,
                "__7"
                );
                list.add(questions);
                questions = new Questions(
                "Աստղագետներն այս երևույթն անվանում են «արևի ստորին գագաթնակետ»: Ո՞րն է դա:",
                "Ամառ",
                "Արևի խավարում",
                "Կեսգիշեր",
                "Մագնիսական փոթորիկ",
                3,
                "__8"
                );
                list.add(questions);



                return list;



    }



}
