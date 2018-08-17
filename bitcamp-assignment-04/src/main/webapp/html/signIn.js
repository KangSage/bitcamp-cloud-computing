"use strict";

$('#loginBtn').click(() => {
    $.post(`${serverApiAddr}/json/auth/signIn`, {
        'email': $('#fEmail').val(),
        'password': $('#fPassword').val(),
        'saveEmail': $('#fSaveEmail').prop('checked')
    }, (result) => {
        if (result.status === 'success') {

        }
    }, 'json')
        .fail((error) => {
            alert('로그인 중 오류 발생');
        });
});
