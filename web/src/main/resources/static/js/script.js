 $(document).ready(function () {
     $("#use50_50").click(function () {
         var answer = $(this).val();
         var settings = {
             "async": true,
             "crossDomain": true,
             "url": "answer",
             "method": "POST",
             "headers": {
                 "answer": answer
             }
         }

         $.ajax(settings).done(function (response) {

             $('#questionTextarea').text(response.question);
             if(response.answer_1=="_________"){
                 $('#answerBtn1').text("-");
                 $('#answerBtn1').prop('disabled', true);
             }
             if(response.answer_2=="_________"){
                 $('#answerBtn2').text("-");
                 $('#answerBtn2').prop('disabled', true);
             }
             if(response.answer_3=="_________"){
                 $('#answerBtn3').text("-");
                 $('#answerBtn3').prop('disabled', true);
             }
             if(response.answer_4=="_________"){
                 $('#answerBtn4').text("-");
                 $('#answerBtn4').prop('disabled', true);
             }

             $('#use50_50').prop('disabled', true);


         });
     });
     $("#beginGame").click(function () {
           var settings = {
                "async": true,
                "crossDomain": true,
                "url": "startGame",
                "method": "GET",
                "headers": {
                }
            }

            $.ajax(settings).done(function (response) {

               $('#questionTextarea').text(response.question);
               $('#answerBtn1').text(response.answer_1);
               $('#answerBtn2').text(response.answer_2);
               $('#answerBtn3').text(response.answer_3);
               $('#answerBtn4').text(response.answer_4);
                $('#use50_50').prop('disabled', false);
            });
        });



     $("#answerBtn1, #answerBtn2, #answerBtn3, #answerBtn4 ").click(function () {
         var answer = $(this).val();
         var settings = {
             "async": true,
             "crossDomain": true,
             "url": "answer",
             "method": "POST",
             "headers": {
                 "answer": answer
             }
         }

         $.ajax(settings).done(function (response) {


         });
     });





    });