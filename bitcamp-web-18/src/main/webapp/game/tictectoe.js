clickListener();
function clickListener () {
    $('.firstTrTd').on('click', function (event) {
        $(event.target).html('x').removeAttr();
        $(this).off('click', autoClick());
    });
}


var autoClick = function () {
    setTimeout(function () {
        let randomNumber = 1; /*Math.floor(Math.random() * 10);*/
        if (randomNumber === 1) {
            console.log('1번 실행');
            if ($('#one').html() === 'o' || $('#one').html() === 'x' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#one').html('o');
                clickListener();
            }
        } else if (randomNumber === 2) {
            console.log('2번 실행');
            if ($('#two').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#two').html('o');
                clickListener();
            }
        } else if (randomNumber === 3) {
            console.log('3번 실행');
            if ($('#three').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#three').html('o');
                clickListener();
            }
        } else if (randomNumber === 4) {
            console.log('4번 실행');
            if ($('#four').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#four').html('o');
                clickListener();
            }
        } else if (randomNumber === 5) {
            console.log('5번 실행');
            if ($('#five').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#five').html('o');
                clickListener();
            }
        } else if (randomNumber === 7) {
            console.log('1번 실행');
            if ($('#one').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#one').html('o');
                clickListener();
            }
        } else if (randomNumber === 8) {
            console.log('1번 실행');
            if ($('#one').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#one').html('o');
                clickListener();
            }
        } else if (randomNumber === 9) {
            console.log('1번 실행');
            if ($('#one').html() == 'o' ) {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#one').html('o');
                clickListener();
            }
        }
    }, 1000);
};
 




