// 과제 : 회원관리, 팀관리, 게시판, 강좌 관리 웹 앱 만들기
const express = require('express');
const app = express();

// POST 요청 데이터를 처리할 모듈 로딩
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended: false}));

// 정적 HTML 파일 처리
app.use(express.static('public'));

// 통합 템플릿 엔진 관리자 모듈 로딩
// => 템플릿 엔진이 아니라 템플릿 엔진을 중간에서 관리해주는 역할을 수행한다.
const consolidate = require('consolidate');


// Express에 템플릿 엔진을 등록한다.
// => consolidate에 대해 handlebars를 지정하면
//    이 템플릿 관리자는 Node 모듈에서 handlebars를 찾아 리턴한다.
// express에 여러개의 엔진을 등록할 수 있다.
app.engine('html', consolidate.handlebars);

// => 등록된 템플릿 엔진 중에서 사용할 엔진을 지정한다.
app.set('view engine', 'html');

// 템플릿 파일이 있는 디렉토리 경로를 지정한다.
const path = require('path');
app.set('views', path.join(__dirname, 'public'));

// "member/*" URL을 처리할 라우터와 'team/*' URL을 처리할 라우터를 로딩한다.
// => 라우터를 Express의 웹서버에 등록한다.
app.use('/member', require('./member'));
app.use('/team', require('./team'));

app.get('/hello', (req, res) => {
    res.write('Hello!');
    res.end();
});

// => 서버 실행하기
app.listen(8000, () => {
    console.log('서버 실행 중...');
});