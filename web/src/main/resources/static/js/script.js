 $(document).ready(function () {

    $("#beginGame").click(function () {
            //var bla = $('#inputButtonPaper').val();
           // var radioButton = Number($('[name="optradio"]:checked').closest('label').text());
            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "startGame",
                "method": "GET",
                "headers": {
                    // "guess": bla,
                    //"radioButton": radioButton,
                }
            }

            $.ajax(settings).done(function (response) {

               // $('#result').text(response.message);
            });
        });




    });