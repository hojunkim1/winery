# Database

## Overview

- 데이터베이스 수정은 무조건 Repository 패키지를 사용한다.

## Entity

- 테이블 구조 정의 파일이며, 데이터베이스 클래스를 도메인으로 변환하는 메소드도 포함하고 있다.

## AppDAtabase

- DAO 어노테이션이 붙어 있는 인터페이스로 데이터베이스를 수정하는 메소드를 정의한다.
- AppDatabase 클래스에 정의된 추상 함수 이외에는 상용구이므로 수정할 필요 없는 코드이다.
- (*중요*) Repository 를 사용할 때, AppDatabase.getDatabase() 를 호출할 필요가 있다.