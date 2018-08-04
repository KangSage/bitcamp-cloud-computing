clickListener();
function clickListener () {
    $('.td').on('click', function (event) {
        $(event.target).html('x');
        $(event.target).removeAttr('class');
        $(this).off('click', autoClick());
    });
}
var autoClick = function () {
    let randomNumber = Math.floor(Math.random() * 10);
    console.log(randomNumber);
    if (randomNumber === 0) {
        return this;
    } else {
    setTimeout(function () {
        if (randomNumber === 1) {
            console.log('1번 실행');
            if ($('#one').html() === 'o' || $('#one').html() === 'x') {
                console.log('리턴전 실행');
                return this;
            } else {
                $('#one').html('o');
                $('#one').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 2) {
            console.log('2번 실행');
            if ($('#two').html() === 'o' || $('#two').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#two').html('o');
                $('#two').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 3) {
            console.log('3번 실행');
            if ($('#three').html() === 'o' || $('#three').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#three').html('o');
                $('#three').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 4) {
            console.log('4번 실행');
            if ($('#four').html() === 'o' || $('#four').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#four').html('o');
                $('#four').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 5) {
            console.log('5번 실행');
            if ($('#five').html() === 'o' || $('#five').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#five').html('o');
                $('#five').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 6) {
            console.log('6번 실행');
            if ($('#six').html() === 'o' || $('#six').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#six').html('o');
                $('#six').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 7) {
            console.log('7번 실행');
            if ($('#seven').html() === 'o' || $('#seven').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#seven').html('o');
                $('#seven').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 8) {
            console.log('8번 실행');
            if ($('#eight').html() === 'o' || $('#eight').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#eight').html('o');
                $('#eight').removeAttr('class');
                clickListener();
            }
        } else if (randomNumber === 9) {
            console.log('9번 실행');
            if ($('#nine').html() === 'o' || $('#nine').html() === 'x') {
                console.log('리턴전 실행');
                return autoClick();
            } else {
                $('#nine').html('o');
                $('#nine').removeAttr('class');
                clickListener();
            }
        }
    }, 2000);}
};
 




