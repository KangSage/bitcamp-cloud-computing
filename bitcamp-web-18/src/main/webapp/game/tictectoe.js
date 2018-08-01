var one = $('#one');

clickListener();

$(document).off('click', 'p');

function clickListener () {
    $('.firstTrTd').on('click', function (event) {
        console.log(event.target.html());
        if(event.target.html == 'o')
            return;
        $(event.target).html('x');
        $(this).off('click', autoClick());
    });
}


var autoClick = function () {
    setTimeout(function () {
        let randomNumber = 1;/*Math.floor(Math.random() * 10);*/
        if (randomNumber === 1) {
            console.log('1번 실행');
            if (one.childElementCount > 0) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#one').append('<p>o</p>');
                clickListener();
            }
        } else if (randomNumber === 2) {
            console.log('2번 실행');
            if ($('#two').childElementCount > 0)
                return autoClick();
            $('#two').html('<p>o</p>');
        } else if (randomNumber === 3) {
            console.log('3번 실행');
            if ($('#three').childElementCount > 0)
                return autoClick();
            $('#three').html('<p>o</p>');
        } else if (randomNumber === 4) {
            console.log('4번 실행');
            if ($('#four').childElementCount > 0)
                return autoClick();
            $('#four').html('<p>o</p>');
        } else if (randomNumber === 5) {
            console.log('5번 실행');
            if ($('#five').childElementCount > 0)
                return autoClick();
            $('#five').html('<p>o</p>');
        } else if (randomNumber === 6) {
            console.log('6번 실행');
            if ($('#six').childElementCount > 0)
                return autoClick();
            $('#six').html('<p>o</p>');
        } else if (randomNumber === 7) {
            console.log('7번 실행');
            if ($('#seven').childElementCount > 0)
                return autoClick();
            $('#seven').html('<p>o</p>');
        } else if (randomNumber === 8) {
            console.log('8번 실행');
            if ($('#eight').childElementCount > 0)
                return autoClick();
            $('#eight').html('<p>o</p>');
        } else if (randomNumber === 9) {
            console.log('9번 실행');
            if ($('#nine').childElementCount > 0)
                return autoClick();
            $('#nine').html('<p>o</p>');
        }
    }, 1000);
};
 




