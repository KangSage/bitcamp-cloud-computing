$('#addBtn').click(() => {
    $.post(`${serverApiAddr}/json/member/signup`, {
        'email': $('#fEmail').val(),
        'name': $('#fName').val(),
        'password': $('#fPassword').val()
    }, (result) => {
        if (result.status === 'success') {
            location.href = 'signIn.html';
        } else {
            alert('회원 가입 실패!');
            console.log(result.message);
        }
    }, 'json')
        .fail((error) => {
            alert('회원가입 중 오류 발생');
        });
});
