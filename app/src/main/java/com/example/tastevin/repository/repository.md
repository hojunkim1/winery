# Repository

## Overview

- 모든 데이터베이스 수정을 이 패키지에서 메소드로 정의한다.
- 데이터베이스와 관련된 로직은 가능하면 ViewModel 에서 작업한다.
- Repository 의 메소드에 대한 설명은 해당 메소드 위에 적어놓았다.

## Usage

'''
val db = Repository(AppDatabase.getDatabase(TastevinApplication()))
val list = db.bookmarkList
db.addBookmark(Wine(...))
'''