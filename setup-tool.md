# 프로그래밍 준비
## 개발 도구 설치
- openjdk 10.0.1
- eclipse photon
- visual studio code
- git client
- scoop (package manager)
- scoop install gradle
- scoop install mysql

## mysql 설정
'''
> mysql -u root -p
Enter password: (암호가 설정되어 있지 않으므로 그냥 엔터)

root 사용자의 암호 설정
mysql > update user set authentication_string=password('1111') where user='root';

암호 변경 후 권한 갱신
mysql> flush privileges;
mysql> quit

다시 접속
> mysql -u root -p
Enter password: 1111
...

애플리케이션에서 DB에 접속할 때 사용할 사용자를 추가한다.
mysql> create user 'study'@'localhost' identified by '1111';



'''

