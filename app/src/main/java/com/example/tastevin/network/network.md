# Network

## Overview

- 사용법은 어렵지 않으나, 테스트해보지 않았기 때문에 일부 오류가 있을 수 있다.

## Usage

1. 별다른 설정 없이 다음과 같이 사용할 수 있다.

"""
val wine = WineApi.retrofitService.getWineById(1)
"""

2. retrofitService 내의 메소드는 Service 파일 내의 Service 에 정의되어 있는 메소드이다.
3. 메소드에 관한 자세한 설명은 해당 메소드 위에 적어놓았다.
4. (*중요*) 다음 메소드들로 받아온 데이터들은 NetworkWine 이므로 도메인으로 변환시켜 줄 필요가 있다.
5. 다행히 해당 메소드를 만들어 놨으므로 데이터 활용 시 해당 과정을 거치는 것을 추천한다.

"""
val wineDomain = wine.asDomainModel()
"""