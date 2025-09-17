 Member-MVC 게시판 프로젝트

## 환경 설정

### 1. 데이터베이스 설정
- MariaDB 설치 및 실행
- 데이터베이스 생성: `backend`
- 사용자 생성: `jhkim` / 비밀번호: `1111`

### 2. SQL 실행
```sql
-- 사용자 및 권한 설정
CREATE USER jhkim@localhost IDENTIFIED BY '1111';
GRANT ALL privileges ON backend.* TO jhkim@localhost WITH GRANT OPTION;
FLUSH PRIVILEGES;

-- 테이블 생성
USE backend;

CREATE TABLE member(
    id VARCHAR(15),
    name VARCHAR(50),
    pwd VARCHAR(15)
);
COMMIT;

INSERT INTO member VALUES('user01','유저1', '1111');
INSERT INTO member VALUES('user02','유저2', '1111');
INSERT INTO member VALUES('user03','유저3', '1111');
INSERT INTO member VALUES('user04','유저4', '1111');
INSERT INTO member VALUES('user05','유저5', '1111');
INSERT INTO member VALUES('user06','유저6', '1111');
INSERT INTO member VALUES('user07','유저7', '1111');
INSERT INTO member VALUES('user08','유저8', '1111');
INSERT INTO member VALUES('user09','유저9', '1111');
INSERT INTO member VALUES('user10','유저10', '1111');
INSERT INTO member VALUES('user11','유저11', '1111');
INSERT INTO member VALUES('user12','유저12', '1111');
INSERT INTO member VALUES('user13','유저13', '1111');
INSERT INTO member VALUES('user14','유저14', '1111');
INSERT INTO member VALUES('user15','유저15', '1111');
INSERT INTO member VALUES('user16','유저16', '1111');
INSERT INTO member VALUES('user17','유저17', '1111');
INSERT INTO member VALUES('user18','유저18', '1111');
INSERT INTO member VALUES('user19','유저19', '1111');
INSERT INTO member VALUES('user20','유저20', '1111');
INSERT INTO member VALUES('user21','유저21', '1111');
INSERT INTO member VALUES('user22','유저22', '1111');
INSERT INTO member VALUES('user23','유저23', '1111');
INSERT INTO member VALUES('user24','유저24', '1111');
INSERT INTO member VALUES('user25','유저25', '1111');
INSERT INTO member VALUES('user26','유저26', '1111');
INSERT INTO member VALUES('user27','유저27', '1111');
INSERT INTO member VALUES('user28','유저28', '1111');
INSERT INTO member VALUES('user29','유저29', '1111');
INSERT INTO member VALUES('user30','유저30', '1111');
INSERT INTO member VALUES('user31','유저31', '1111');
INSERT INTO member VALUES('user32','유저32', '1111');
INSERT INTO member VALUES('user33','유저33', '1111');
INSERT INTO member VALUES('user34','유저34', '1111');
INSERT INTO member VALUES('user35','유저35', '1111');
INSERT INTO member VALUES('user36','유저36', '1111');
INSERT INTO member VALUES('user37','유저37', '1111');
INSERT INTO member VALUES('user38','유저38', '1111');
INSERT INTO member VALUES('user39','유저39', '1111');
INSERT INTO member VALUES('user40','유저40', '1111');
INSERT INTO member VALUES('user41','유저41', '1111');
INSERT INTO member VALUES('user42','유저42', '1111');
INSERT INTO member VALUES('user43','유저43', '1111');
INSERT INTO member VALUES('user44','유저44', '1111');
INSERT INTO member VALUES('user45','유저45', '1111');
INSERT INTO member VALUES('user46','유저46', '1111');
INSERT INTO member VALUES('user47','유저47', '1111');
INSERT INTO member VALUES('user48','유저48', '1111');
INSERT INTO member VALUES('user49','유저49', '1111');
INSERT INTO member VALUES('user50','유저50', '1111');
INSERT INTO member VALUES('user51','유저51', '1111');
INSERT INTO member VALUES('user52','유저52', '1111');
INSERT INTO member VALUES('user53','유저53', '1111');
INSERT INTO member VALUES('user54','유저54', '1111');
INSERT INTO member VALUES('user55','유저55', '1111');
INSERT INTO member VALUES('user56','유저56', '1111');
INSERT INTO member VALUES('user57','유저57', '1111');
INSERT INTO member VALUES('user58','유저58', '1111');
INSERT INTO member VALUES('user59','유저59', '1111');
INSERT INTO member VALUES('user60','유저60', '1111');
INSERT INTO member VALUES('user61','유저61', '1111');
INSERT INTO member VALUES('user62','유저62', '1111');
INSERT INTO member VALUES('user63','유저63', '1111');

SELECT COUNT(*) FROM member;
SELECT * FROM member LIMIT 5;
SELECT * FROM member LIMIT 10, 10;


USE backend;

SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;


-- BOARD 테이블 생성 (UTF-8 문자셋)
CREATE TABLE BOARD(
    BCODE INT AUTO_INCREMENT PRIMARY KEY,
    SUBJECT VARCHAR(100),
    CONTENT TEXT,
    WRITER VARCHAR(50),
    REGDATE DATE
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- REPLY 테이블 생성 (UTF-8 문자셋)
CREATE TABLE REPLY(
    RCODE INT AUTO_INCREMENT PRIMARY KEY,
    BCODE INT,
    REPLY VARCHAR(200),
    WRITER VARCHAR(50),
    REGDATE DATE
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- BOARD 데이터 삽입
INSERT INTO board(subject, content, writer, regdate) VALUES('안녕1', '반가워요', 'gildong', SYSDATE());
INSERT INTO board(subject, content, writer, regdate) VALUES('안녕2', '반가워요2', 'gildong2', SYSDATE());
INSERT INTO board(subject, content, writer, regdate) VALUES('안녕3', '반가워요3', 'gildong3', SYSDATE());
INSERT INTO board(subject, content, writer, regdate) VALUES('안녕4', '반가워요4', 'gildong4', SYSDATE());

-- REPLY 데이터 삽입
INSERT INTO reply(bcode, reply, writer) VALUES(1, '저도 안녕', 'sunshin');
INSERT INTO reply(bcode, reply, writer) VALUES(1, '잘 지내고 계시죠?', 'sunyoung');

-- 데이터 확인
SELECT * FROM board;
SELECT * FROM reply;

-- 테이블 구조 확인
SHOW CREATE TABLE board;
SHOW CREATE TABLE reply;


Eclipse에서 프로젝트 import
Tomcat 서버 설정
프로젝트를 서버에 배포
접속: http://localhost:8080/member-mvc/index.do

주요 기능

회원 관리 (CRUD)
게시판 관리 (페이지네이션 포함)
