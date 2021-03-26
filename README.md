# 야구 관리 프로그램

## 의존성
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Web


``` MySQL
CREATE USER 'baseball'@'%' identified by '1234';
GRANT ALL privileges on *.* to 'baseball'@'%';
CREATE DATABASE baseball;

```

db 업데이트로 바꿀것