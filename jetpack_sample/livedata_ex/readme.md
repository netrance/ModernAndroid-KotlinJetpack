# 시작하며...

이 샘플 모듈의 개발 목적은 다음과 같습니다.

* LiveData 라이브러리를 활용하여 데이터 변경을 관찰하고 이를 처리하는 방법을 이해한다.

---

# 스크린샷

스크린샷은 [Room DB 샘플 코드](../room_ex/)와 동일합니다. 차이점은 기존 코드를 가지고 와서 LiveData를 적용했다는 점입니다.

---

# 주목할 점

DAO 클래스에서 SELECT 문 실행 함수의 리턴값이 라이브데이터이고 그것의 observe 함수를 실행하여 observer를 등록하면, 
테이블의 자료가 추가/변경/삭제될 때마다 observer가 실행되어 자료 변경을 처리할 수 있습니다. 
예를 들면 자료가 추가/변경/삭제시 UI 업데이트를 할 수가 있는 것입니다. 

---

# 강의 URL

* [[Kotlin] LiveData](https://www.inflearn.com/course/%EB%AA%A8%EB%8D%98-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%A0%9C%ED%8A%B8%ED%8C%A9/lecture/49127?tab=curriculum&volume=1.00&speed=1.25)