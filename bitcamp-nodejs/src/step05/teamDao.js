// 주제 : DAO 모둘 만들기
var pool;

exports.setConnectionPool = (connectionPool) => {
    pool = connectionPool;
};

exports.list = (pageNo = 1, pageSize = 3, handler) => {
    console.log('team/list 실행');
    var startIndex = (pageNo - 1) * pageSize;
    pool.query('select name, sdt, edt, max_qty from pms2_team limit ?, ?',
        [startIndex, pageSize],
        function(err, results) {
            handler(err, results);
        });
};

exports.view = (data, handler) => {
    console.log('team/view 실행');
    pool.query('select name, dscrt, sdt, edt, max_qty from pms2_team where name=?',
        [data.name],
        function(err, results) {
            handler(err, results);
        });
};

exports.add = (data, handler) => {
    pool.query(
        'insert into pms2_team(name,dscrt,max_qty,sdt,edt)\
        values(?,?,?,?,?)',
        [data.name, data.description, data.maxQuantity, data.startDate, data.endDate],
        function(err, result) {
            handler(err, result);
        });
};

exports.update = (data, handler) => {
    pool.query(
        'update pms2_team\
        set dscrt=?, max_qty=?, sdt=?, edt=?\
        where name=?',
        [data.description,
            data.maxQuantity,
            data.startDate,
            data.endDate,
            data.name],
        function(err, result) {
            handler(err, result);
        });
};

exports.remove = (data, handler) => {
    pool.query('delete from pms2_team where name=?',
        [data.name],
        function(err, result) {
            handler(err, result);
        });
};