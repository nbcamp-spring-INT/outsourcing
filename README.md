# I-편한세상
![image](https://github.com/nbcamp-spring-INT/outsourcing/assets/97017924/19d5430d-cb3e-4087-9a48-e4f2e0566b97)
- 프로젝트 명 : I-편한세상
- 소개
  - 한 줄 소개 : I들의 속마음을 털어놓는 SNS 내용 추천받습니다
  - 내용 : 
---
## 1. 프로젝트 구성

## 2. 와이어프레임
<https://www.figma.com/file/09zUaNefMwLwSymtJ6UOVB/INT?type=whiteboard&node-id=0-1&t=55D4j831dq5X3UVw-0>

## 3. API
<img width="1150" alt="image" src="https://github.com/nbcamp-spring-INT/outsourcing/assets/97017924/615a1dd7-5527-4505-9428-9de711985191">
<img width="1140" alt="image" src="https://github.com/nbcamp-spring-INT/outsourcing/assets/97017924/b3fd6fe8-ee23-4eb2-9160-ead78e3e2352">

## 4. ERD
![image](https://github.com/nbcamp-spring-INT/outsourcing/assets/97017924/8fd85d34-0968-43dd-b40f-c68801180bff)
![image](https://github.com/nbcamp-spring-INT/outsourcing/assets/97017924/9da24bc5-3746-4635-ade6-4814867f30c9)
![image](https://github.com/nbcamp-spring-INT/outsourcing/assets/97017924/c1e9e2c0-4c05-44b7-b86e-daab5c65c2c7)

## 5. CODE CONVENTION
- 1. feat/domain
- 2. git commit 메시지 깃모지 feat(domain): ~~~
- 3. naver 코드 컨벤션
- 4. serviceImpl, repositoryImpl
- 5. 도메인별 3 layer 패키지 만들기
- 6. 피드 & 댓글 soft delete
- 7. input & output 타입
     
  - 데이터베이스로 저장하러 가는 중
    - controller -> service (requestDto)
    - serivce -> repository (entity)

  - 데이터베이스 저장 or 조회 후
    - repository -> service (model)
    - service -> controller (responseDto)
    - controller -> frontend (CommonResponseDto)

  - 해당 도메인이 해당 도메인의 id로 객체를 가져올 때
    - Optional<FeedModel> findById(Long feedId)
    - FeedModel findByIdOrElseThrow(Long feedId)

  - 다른 도메인의 id로 해당 도메인의 객체를 가져올 때
    - Optional<FeedModel> findByMemberId(Long memberId)
    - FeedModel findByIdMemberIdOrElseThrow(Long memberId)


- 8. 기타 로컬 환경 설정

  - application-dev.yml -> 각자 로컬의 설정에 맞게 하기 위해
  - db.properties -> 로컬환경에 맞는 데이터베이스 세팅을 위한 환경변수 설정
  - jwt.properties -> jwt토큰 관련 jwt secret key, admin key 환경변수 설정
  - gitignore해서 정보 보호

## 6. 개발환경
  - JAVA 17
  - Spring boot 3.2.2
  - MySQL 8.0.33
  - Swagger 2.3.0
  - Slack
  - GitHub, Git
