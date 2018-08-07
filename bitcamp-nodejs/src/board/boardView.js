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

var bno = 31;

con.query(
    `select bno,titl,cont,cdt 
    from pms2_board where bno=?`,
    [bno],
    function(err, results) {
        if (err) throw err;
        for (var row of results) {
            console.log('번호 :', row.bno);
            console.log('제목 :', row.titl);
            console.log('내용 :', row.cont);
            console.log('등록일 :', row.cdt);
        }
    });


con.end(function(err) {
    if (err) throw err;
    console.log('연결을 끊었습니다!')
});

console.log('board insert 실행!');