# Blinding Adapter

## 데이터 바인딩에 대하여

1. 우선, fragment 의 onViewCreated에 다음과 같이 코드를 적어본다.

"""
binding.homeViewModel = viewModel
binding.lifecycleOwner = viewLifecycleOwner
"""

2. homeViewModel은 fragment_home 에 다음과 같이 정의된 부분의 바인딩이다.

"""
<data>
<variable
name="homeViewModel"
type="com.example.tastevin.ui.home.HomeViewModel" />
</data>
"""

3. 이는 "데이터 바인딩"으로, xml 파일 내에서 다음과 같이 viewModel 의 데이터에 접근할 수 있다.
4. 데이터 바인딩을 활용하기 위해서, xml 파일의 컨테이너는 layout로 변경해야 한다.
   (이때, xml 코드 위에서 우클릭 후, show context action 을 누르면 layout으로 변경하는 버튼이 뜬다.)

"""
app:text="@{viewModel.score}"
"""

5. 여기서 접근한 photos 는 LiveData<T> 타입으로 정의한다.

"""
private val _score = MutableLiveData(0)
val score: LiveData<Int> get() = _score
"""

6. 앱 내에서 변수가 업데이트되면 별다른 명령 없이도 바로 화면에 적용된다.

## 블라인딩 어댑터에 대하여

- 블라인딩 어댑터는 MVVM 구조의 옵저버 패턴을 위한 중요 라이브러리이다.
- 하지만, 사용하기 꽤 까다롭기 때문에 필요하지 않다면 사용하지 말고 데이터 바인딩까지만 활용하자.