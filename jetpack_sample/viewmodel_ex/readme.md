# 시작하며...

이 샘플 모듈의 개발 목적은 다음과 같습니다.

* ViewModel 상속 클래스를 정의하는 방법을 이해한다.
* 액티비티에서 작성하던 로직을 뷰모델로 옮기는 방법을 이해한다.

---

# 스크린샷

스크린샷은 [Room DB 샘플 코드](../room_ex/), [LiveData 샘플 코드](../livedata_ex/)와 동일합니다. 
차이점은 기존 코드를 가지고 와서 ViewModel, LiveData를 적용했다는 점입니다.

---

# 주목할 점

뷰모델을 구현하여 액티비티에 집중되던 코드가 두 클래스로 분산되는 것을 경험해볼 수 있습니다. 
이번 샘플에서는 코드의 양이 작아서 크게 와닿지는 않을 수도 있지만, 
실무에서 코딩을 많이 해보시면 이해하실 수 있을 것입니다.

---

# 강의 URL

* [[Java] UI와 로직 분리 ViewModel](https://www.inflearn.com/course/%EB%AA%A8%EB%8D%98-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%A0%9C%ED%8A%B8%ED%8C%A9/lecture/49128)
* [[Java] ViewModel 사용법 변경 사항 (업데이트)](https://www.inflearn.com/course/%EB%AA%A8%EB%8D%98-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%A0%9C%ED%8A%B8%ED%8C%A9/lecture/49129)
* [[Kotlin] UI와 로직 분리 ViewModel](https://www.inflearn.com/course/%EB%AA%A8%EB%8D%98-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%A0%9C%ED%8A%B8%ED%8C%A9/lecture/49130)