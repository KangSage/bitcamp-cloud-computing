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

    con.query('select bno,titl,cdt from pms2_board', function(err, results) {
        if (err) throw err;
        console.log("번호|제목|내용");
        for (var row of results) {
            console.log(row.bno, row.titl, row.cdt);
        }
    });

    // end도 SQL 실행 후에 종료하라고 예약해야 한다.
    con.end(function(err) {
        if (err) throw err;

        console.log('연결을 끊었습니다!')
    });
});


console.log('board select 실행!');