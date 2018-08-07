const mysql = require('mysql');

var con = mysql.createConnection({
    host: '13.209.19.155',
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

con.connect(function(err) {
    if (err) throw err;

    console.log('연결 성공입니다!');
});

var title = '제목입니다.';
var cont = '내용이래요';

con.query(
    `insert into pms2_board(titl,cont,cdt) values('${title}','${cont}',now())`,
    function(err, result) {
        if (err) throw err;

        console.log('입력 성공!');
    });


con.end(function(err) {
    if (err) throw err;
    console.log('연결을 끊었습니다!')
});

console.log('board insert 실행!');