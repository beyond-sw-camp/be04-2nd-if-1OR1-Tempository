<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EB%A1%9C%EA%B3%A0.jpg">
</div>
<div align=center>

## 💻 TEAM if(1=1)
<a href = "https://www.notion.so/1-if-1-1-65fccb6e46b546c7be44d4bbb6b878eb?pvs=4"><img src="https://img.shields.io/badge/Team Notion-ffffff?style=social&logo=Notion&logoColor=black" /></a>
<br>
<br>
[😎곽윤경](https://github.com/noctesilente)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[🎸이기연](https://github.com/Leegiyeon)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[🐰이예원](https://github.com/onelee521)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[😺임원재](https://github.com/moomint8)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[🐶정우진](https://github.com/Wrinkk)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>

---

<br>

<div align=center>
	<h2>📚 Tech Stack 📚</h2>
	<p>✨ Platforms & Languages ✨</p>
</div>
<div align="center">
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=Spring&logoColor=white" />
	<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white" />
    <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Conda-Forge&logoColor=white" />
    <br>
    <img src="https://img.shields.io/badge/MariaDB-003545?style=flat&logo=MariaDB&logoColor=white" />
    <img src="https://img.shields.io/badge/Mybatis-000000?style=flat&logo=Fluentd&logoColor=white" />
</div>
<br>
<div align=center>
	<h2>🛠 Tools 🛠</h2>
</div>
<div align=center>
	<img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=flat&logo=intellij-idea&logoColor=white" />
	<img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white" />
    <img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=Notion&logoColor=white" />
    <br>
    <img src="https://img.shields.io/badge/Miro-050038?style=flat&logo=Miro&logoColor=white" />
    <img src="https://img.shields.io/badge/Figma-F24E1E?style=flat&logo=Figma&logoColor=white" />
</div>
<br>
<br>
<div align=center>
<h2> 🗓️ 전체 프로젝트 일정 </h2>
2024.02.26 ~ 2024.03.11(WBS)
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/WBS%201.png" />
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/WBS%202.png" />
</div>
</div>

<br>
<br>

---
<br>
<h1> 📌 목차 </h1>
<h3> 1. 프로젝트 개요 </h3>
<h3> 2. 요구사항 정의 </h3>
<h3> 3. DDD </h3>
<h3> 4. CRUD 기능 구현 </h3>
<h3> 5. 개선사항 및 회고 </h3>



---
<br>
<br>
<br>

# 1. 프로젝트  개요

## 아이디어 기획
- 문제 인식: 대학생 또는 취업 준비생들이 각자 본인의 직무 분야 전문 이력을 만들어가는 것에 어려움이 많음.
- 문제 원인: 취업을 준비하는 대학생들은 현업에서 프로젝트가 어떻게 진행되는지 알기 어렵기 때문이라 판단.
- 해결 방안 제안: 프로젝트 운영과정을 Template으로 제공하고, 프로젝트 완료 시, 문서로 저장하여 이력을 활용할 수 있도록 하는 서비스를 제공
<br>

## 프로젝트 시나리오
취준생 및 대학생 개발자들을 위한 프로젝트 관리 및 문서(WBS, 요구사항 명세서, 테이블 정의서 등) 작성 서비스를 제공하는 플랫폼
- 초기 프로젝트 진행 시 필요한 문서 작성을 위한 템플릿 제공하여 프로젝트 시작을 용이하게 함
- 프로젝트 관리 기능과 팀 협업 기능을 결합하여 효율적인 프로젝트 진행을 지원함
- 팀장 또는 프로젝트 개설자가 프로젝트 생성
- 프로젝트 내 참여 회원 초대
- 프로젝트로 참여하는 회원은 최초에 관리자 권한이 없음(관리자가 권한 설정 가능)
- 프로젝트 하위 Template 사용을 통해 프로젝트 진행
- 확장 예정 기능: RESUME, 커뮤니티, 멘토 멘티
<br>

## 주요 기능
- 문서 작성 템플릿 제공: WBS, 요구사항 명세서, 테이블 정의서 등 다양한 문서 템플릿 제공
- 협업 기능 및 프로젝트 관리: 팀원 초대, 파일 공유 등을 통한 팀 협업 지원
<br>

## 목표 및 기대효과
- 취준생 및 대학생 개발자들이 프로젝트를 시작할 때 어떤 문서를 작성해야 할지에 대한 불안을 해소하여 프로젝트 시작을 쉽게 할 수 있음
- 팀 협업과 프로젝트 관리가 한데 묶인 서비스로, 개발 능력뿐만 아니라 프로젝트 관리 및 협업 능력도 함께 강화할 수 있음
- 개발자로서의 경력 구축 및 취업 준비를 위한 포트폴리오 강화에 도움을 줄 것으로 기대됨
<br>

<br>

## 프로젝트 아키텍쳐
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90%20%EC%9D%B4%EB%AF%B8%EC%A7%80.jpg">
</div>
<br>

---
<br>
<br>

# 2. 요구사항 정의
## 시나리오

### 프로젝트
1. 프로젝트 관리
- 회원은 프로젝트를 추가, 수정, 삭제 할 수 있음
2. 프로젝트 조회
- 회원은 공개된 프로젝트를 조회 할 수 있음
3. 참여한 프로젝트 조회
- 회원은 자신이 참여한 프로젝트 정보를 조회 할 수 있음
4. 프로젝트 참여 멤버 정보 조회
- 회원은 프로젝트 참여 멤버 정보를 조회 할 수 있음

### 테스트케이스
1. 테스트케이스 관리
회원은 테스트케이스를 추가, 수정,  순서 변경, 삭제할 수 있음

2. 테스트케이스 조회
회원은 테스트케이스를 조회할 수 있음

3. 테스트케이스 결과 조회
회원은 테스트케이스 결과별로 조회할 수 있음



### 요구사항 명세서
1. 요구사항 명세서 관리
회원은 요구사항 명세서를 추가, 수정,  순서 변경, 삭제 할 수 있음

2. 요구사항 명세서 조회
회원은 요구사항 명세서를 조회할 수 있음

### 이슈
1. 이슈 담당자 조회
회원은 해당 이슈와 함께 담당자의 정보를 조회할 수 있음

<br>
<br>

## 요구사항 명세서
[요구사항 명세서](https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EB%AA%85%EC%84%B8%EC%84%9C.pdf)
<br>
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EB%AA%85%EC%84%B8%EC%84%9C.png">
</div>

<br>

## 기능 명세서
[기능 명세서](https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EA%B8%B0%EB%8A%A5%20%EB%AA%85%EC%84%B8%EC%84%9C.pdf)
<br>
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EA%B8%B0%EB%8A%A5%20%EB%AA%85%EC%84%B8%EC%84%9C.png">
</div>

<br>

---
<br>
<br>

# 3. DDD

## miro를 통한 이벤트스토밍
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDD/DDD%20-%20%EC%9D%B4%EB%B2%A4%ED%8A%B8%EC%8A%A4%ED%86%A0%EB%B0%8D.png">
</div>

## 컨텍스트 매핑
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDD/DDD%20-%20%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%20%EB%A7%B5%201.png">
</div>

### 우선순위가 구분된 컨텍스트 맵
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDD/DDD%20-%20%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%20%EB%A7%B5%202%20-%20%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84%EA%B0%80%20%EA%B5%AC%EB%B6%84%EB%90%9C%20DDD.png">
</div>

<br>
<br>

## 논리 모델링 및 물리 모델링
<div align=center>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EB%85%BC%EB%A6%AC%20%EB%AA%A8%EB%8D%B8%EB%A7%81.png">
<br>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/%EB%AC%BC%EB%A6%AC%EB%AA%A8%EB%8D%B8%EB%A7%81.png">
</div>

<br>

## Data Definition Language(DDL)
<details>
<summary> user 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/user.png">
</details>

<details>
<summary> project 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/project.png">
</details>

<details>
<summary> resume 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/resume.png">
</details>
<details>
<summary> follow 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/follow.png">
</details>
<details>
<summary> like 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/like.png">
</details>
<details>
<summary> project member 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/project%20member.png">
</details>
<details>
<summary> resume project 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/resume%20project.png">
</details>
<details>
<summary> project issue 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/project%20issue.png">
</details>
<details>
<summary> project testcase 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/project%20testcase.png">
</details>
<details>
<summary> project wbs 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/project%20wbs.png">
</details>
<details>
<summary> project definition of table 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/definiton%20of%20table.png">
</details>
<details>
<summary> project requirement 테이블 생성 </summary>
<img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/DDL/project%20requirement.png">
</details>


<br>
<br>

---
<br>

# 4. CRUD 기능 구현 - 테스트 설계 및 진행

## 계층 구조 설계
gateway 및 eureka 서버 사용
<br>
Mybatis, Spring data jpa 사용
<br>
MSA - feign client
<br>
<br>

## REST API
[API 설계서](https://github.com/if-1OR1/Tempository-MSA/blob/main/docs/Image/API%20%EC%84%A4%EA%B3%84.pdf)
<br>

## 테스트 설계
[테스트케이스](https://github.com/if-1OR1/Tempository-MSA/blob/main/docs/Image/%ED%85%8C%EC%8A%A4%ED%8A%B8%EC%BC%80%EC%9D%B4%EC%8A%A4.pdf)
<br>
<br>


## 테스트 결과
### Query
#### User
<details>
<summary> 사용자 로그인 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_login.png"/>
</details>

<details>
<summary> 사용자를 이메일로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_find_by_email.png"/>
</details>

<details>
<summary> 사용자를 ID로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_find_by_id.png"/>
</details>

<details>
<summary> 사용자를 token으로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_find_by_token.png"/>
</details>

<details>
<summary> 프로젝트 참여 멤버들 정보 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_project_join-members.png"/>
</details>

<br>
<details>
<summary> 사용자 비밀번호 수정 </summary>
	<p>실패</p>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_updatePassword_fail.png"/>
	<p>성공</p>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_updatePassword_success.png">
	<p>결과</p>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_updatePassword_result.png">
</details>

<details>
<summary> 시용자 정보 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/query_user_updateUserInfo.png"/>
</details>
<br>

#### Project
<details>
<summary> 프로젝트를 이름으로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_searchName.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_searchName_Result.jpg">
</details>

<details>
<summary> 프로젝트를 ID로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findById.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findById_Result.jpg">
</details>

<details>
<summary> 프로젝트를 공개 유무로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findByIsPublic.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findByIsPublic_Result.jpg">
</details>

<details>
<summary> 프로젝트를 상태(완료, 미완)로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findByStatus.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findByStatus_Result.jpg">
</details>

<details>
<summary> 프로젝트를 좋아요 순으로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findOrderByLike.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findOrderByLike_Result.jpg">
</details>

<details>
<summary> 프로젝트를 내용 검색으로 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_searchContent.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_searchContent_Result.jpg">
</details>

<details>
<summary> 프로젝트 정보와 프로젝트 참여 회원 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findProjectMember.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findProjectMember_Result.jpg">
</details>

<details>
<summary> 요청이 들어온 ID를 통하여 프로젝트 이름 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findProjectNameById.jpg"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/query_findProjectNameById_Result.jpg">
</details>
<br>

#### Project Template - WBS
<details>
<summary> WBS 조회 - 프로젝트 ID/담당자 ID/프로젝트 ID와 담당자 ID </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20select%20-%20%EC%A1%B0%ED%9A%8C%203%EA%B0%9C%20%EB%8B%A4%20-%201.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20select%20-%20%EC%A1%B0%ED%9A%8C%203%EA%B0%9C%20%EB%8B%A4%20-%202.png">
</details>
<br>

#### Project Template - Issue
<details>
<summary> Issue 조회 - 프로젝트 ID/이슈 상태(CLOSED) </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/query_Issue_Code.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/query_Issue.png">
</details>

<details>
<summary> Issue를 프로젝트 ID로 조회할 때 사용자 정보까지 조회 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/query_Issue_FeignClient.png"/>
</details>
<br>

#### Project Template - Definition of Table
<details>
<summary> 테이블 정의서 조회 - 프로젝트 ID/테이블 명 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/query_DefinitionOfTable_Code.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/query_DefinitionOfTable.png">
</details>
<br>

#### Project Template - Requirement
<details>
<summary> 요구사항 조회 - 프로젝트 ID/separate과 프로젝트 ID/요구사항 번호와 프로젝트 ID </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/query_Requirement_Code.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/query_Requirement.png">
</details>
<br>

#### Project Template - Testcase
<details>
<summary> 테스트케이스 조회 - 프로젝트 ID/separate과 프로젝트 ID/결과와 프로젝트 ID/테스트케이스 번호와 프로젝트 ID </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/query_Testcase_Code1.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/query_Testcase_Code2.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/query_Testcase.png">
</details>




<br>

### Command
#### User
<details>
<summary> 회원가입 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/user-service/command_user_signUp.png"/>
</details>
<br>

#### Project
<details>
<summary> 프로젝트 추가 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/Command_ProjectRegist.jpg">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/Command_Project_Regist_Result.jpg"/>
</details>

<details>
<summary> 프로젝트 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/Command_ProjectModify.jpg">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/Command_Project_Modify_Result.jpg"/>
</details>

<details>
<summary> 프로젝트 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/Command_ProjectDelete.jpg">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Project_Service/Project_Service/Command_Project_Delete_Result.jpg"/>
</details>
<br>

#### Project Template - WBS
<details>
<summary> WBS 추가 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20regist1%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20regist1%20-%202.png"/>
</details>

<details>
<summary> 프로젝트 ID로 WBS 추가 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20regist2%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20regist2%20-%202.png"/>
</details>

<details>
<summary> 프로젝트 ID로 WBS 여러 개 일괄 추가 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20regist3%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20regist3%20-%202.png"/>
</details>

<details>
<summary> 프로젝트 ID와 WBS 번호로 WBS 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify1%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify1%20-%202.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify1%20-%203.png">
</details>

<details>
<summary> 해당 프로젝트 WBS 상태를 전부 COMPLETED로 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify2%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify2%20-%202.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify2%20-%203.png">
</details>

<details>
<summary> 프로젝트 ID와 WBS 번호로 WBS 내용만 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify3%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify3%20-%202.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20modify3%20-%203.png">
</details>

<details>
<summary> 프로젝트 ID와 WBS 번호로 WBS 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20delete1%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20delete1%20-%202.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20delete1%20-%203.png">
</details>

<details>
<summary> 프로젝트 ID로 해당하는 WBS 전부 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20delete2%20-%201.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20delete2%20-%202.png"/>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/wbs/project-template%20-%20wbs%20-%20delete2%20-%203.png">
</details>
<br>

#### Project Template - Issue
<details>
<summary> 이슈 추가 및 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Issue_RegistAndModify.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Issue_DB.png"/>
</details>

<details>
<summary> 해당 프로젝트 이슈 상태를 전부 OPEN으로 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Issue_ModifyStatusOpen.png">
</details>

<details>
<summary> 해당 프로젝트 이슈 상태를 전부 CLOSED로 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Issue_ModifyStatusClosed.png">
</details>

<details>
<summary> 프로젝트 ID와 이슈 번호로 이슈 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Issue_RemoveByProjectIdAndDefinitionNo.png">
</details>

<details>
<summary> 프로젝트 ID로 해당하는 이슈 전부 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Issue_RemoveByProjectId.png">
</details>
<br>

#### Project Template - Definition of Table
<details>
<summary> 토큰 사용을 위해 회원가입 후 로그인 진행 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_SignUp.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Login.png"/>
</details>

<details>
<summary> 테이블 정의서 추가 및 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Definition_RegistAndModify.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_DefinitionOfTable_DB.png"/>
</details>

<details>
<summary> 프로젝트 ID와 테이블 정의서 번호로 테이블 정의서 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Definition_RemoveByProjectIdAndDefinitionNo.png">
</details>

<details>
<summary> 프로젝트 ID로 해당하는 테이블 정의서 전부 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/Image_Tempogitory_Isuue_Definition/command_Definition_RemoveByProjectId.png">
</details>
<br>

#### Project Template - Requirement
<details>
<summary> 요구사항 추가 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_Regist.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_Regist_DB.png"/>
</details>

<details>
<summary> 요구사항 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_Modify.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_Modify_DB.png"/>
</details>

<details>
<summary> 요구사항 순서 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_ModifySequence.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_ModifySequence_DB.png"/>
</details>

<details>
<summary> 프로젝트 ID와 요구사항 번호로 요구사항 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_Remove.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_Remove_DB.png">
</details>

<details>
<summary> 프로젝트 ID로 해당하는 요구사항 전부 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_RemoveAll.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Requirement_RemoveAll_DB.png">
</details>
<br>

#### Project Template - Testcase
<details>
<summary> 테스트케이스 추가 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_Regist.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_Regist_DB.png"/>
</details>

<details>
<summary> 테스트케이스 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_Modify.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_Modify_DB.png"/>
</details>

<details>
<summary> 테스트케이스 순서 수정 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_ModifySquence.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_ModifySquence_DB.png"/>
</details>

<details>
<summary> 프로젝트 ID와 테스트케이스 번호로 테스트케이스 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_Remove.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_Remove_DB.png">
</details>

<details>
<summary> 프로젝트 ID로 해당하는 테스트케이스 전부 삭제 </summary>
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_RemoveAll.png">
  <img src="https://github.com/beyond-sw-camp/be04-2nd-if-1OR1-Tempository/blob/main/docs/Image/test/requirement_testcast_service/requirement_testcast_service/command_Testcase_RemoveAll_DB.png">
</details>

---
<br>
<br>


# 5. 개선사항 및 회고
## 개선사항
feign client -> put delete mapping에도 적용
<br>

## 회고
😎곽윤경
<br>
이번 프로젝트에서는 MyBatis, JPA, REST API 등 다양한 백엔드 기술을 적용하고 익히는 데에 주력했습니다. 특히, 프론트엔드 없이도 모든 계산이 백엔드에서 이루어지도록 하는 것이 주요 목표였기 때문에, 이를 실현하기 위해 CRUD 기능들을 구현하는 데에 집중했습니다. 이때 조회는 MyBatis로, 추가, 수정, 삭제는 JPA로 구현하는 방식을 선택했습니다. 또한, 이번 프로젝트에서는 처음부터 도메인 주도 설계(DDD)의 방법 중 이벤트스토밍과 컨텍스트 매핑을 활용하여 도메인의 작동 방식을 시각화하고, 각 도메인 간의 경계를 명확하게 정의했습니다. 이를 통해 서로 다른 도메인 간의 상호작용을 효율적으로 이루어지도록 설계했습니다.
<br>
같은 서비스를 구현하는 것이라도 각 팀원이 가지고 있는 큰 그림이나 설계는 다를 수 있음을 깨달았습니다. 이를 해결하기 위해서는 각 컨텍스트의 경계를 명확히 정의하고 이해하는 것이 중요하다는 것을 알게 되었고, 이를 위해서는 팀 간의 의사소통이 매우 중요하다는 것을 인식했습니다. 프로젝트에 모두가 동일한 비전을 공유하고 그에 맞춰 진행하기 위해서는 의사소통이 확실히 이루어져야 합니다. 인원이 많아질수록 이를 더욱 확실히 해야 한다는 생각이 들었습니다.
이번 프로젝트에서는 도메인 주도 설계(DDD)를 시작으로 팀원들과의 소통이 매우 중요하다는 것을 깨닫게 되었습니다. 기능을 구현하는 과정에서도 꾸준한 의견 공유와 의문 해결을 위한 시간을 팀원들과 자주 가졌습니다. 또한, 각자가 맡은 기능을 구현할 때는 컨벤션을 명확히 정의하지 않으면 프로젝트가 혼란스러워질 수 있다는 점을 인식했습니다. 이를 통해 팀원 간의 코드를 이해하기 위해서는 명확한 메소드 명과 주석, 그리고 일관된 컨벤션을 적용하는 것이 중요하다는 것을 깨달았습니다. 이를 바탕으로 계속해서 코드 품질을 향상시키고 발전시킬 계획입니다.
이번 프로젝트를 통해 배운 것들을 단순히 여기서 마무리하지 않고, 앞으로도 발전시켜 나가려고 합니다. 프론트엔드까지 적용하여 프로젝트를 실제 서비스 수준까지 발전시키고자 합니다. 
<br>
<br>
🎸이기연
<br>
이번 프로젝트에서 기획한 서비스를 도메인 주도 설계방식으로 작업할 수 있었다. 그 과정에서 도메인 주도 설계가 초기 구조 설계에 필수적이라는 생각을 하게 되었다. 추상적인 설계 형태가 아닌 구체적인 기능 도메인 단위로 구분하여 명확하게 확인할 수 있다는 점에서 그렇게 생각하게 된 것 같다.
이후 기능을 구현해나가는 과정에서 시스템 설계 방식에 대한 고민도 할 수 있었다. 
모놀리딕 형태로 시작한 프로젝트는 추후 확장할 기능들을 생각하여 ‘MSA’ 설계 방식으로 진행하였다.
처음에는 ‘MSA’는 것이 그저 기능단위로 나누고 각 기능마다 독립성을 주는 것에 목적을 둔다고 생각했다.
그러나 많이 나누면 나눌수록 팀 단위 인력을 포함한 인프라가 추가 되어야 함을 알게되었고, 반복적으로 자주 쓰이는 기능 또는 지속적으로 이슈가 잦은 기능들에 대해 ‘MSA’를 적용하는것이 ‘마이크로 서비스 아키텍처’를 잘 사용하는 법이라 생각하게되었다.
해당 프로젝트는 지금 끝이 아닌 실제 서비스를 할 수 있는 단계까지 개발을 진행 할 예정이다.
과정에서 Code 리팩토링, Github 사용시 컨벤션 통일 등을 진행하며 더 발전 시키고자 한다.
<br>
<br>
🐰이예원
<br>
스프링부트와 MSA를 적용한 프로젝트는 처음 경험해보는 것이었는데 이 프로젝트를 통해서 컨트롤러와 서비스끼리의 전달 DTO, Entity, VO가 어떻게 구분되는지 알게 되었다. 또한 rest api 방식을 사용하여 나중에 어떤 프론트엔드와도 통신할 수 있게 만들었다. Feign Client를 사용하여 MSA로 나누어진 서버끼리 소통할 수 있다. 추후 프로젝트 기간 동안 추가 기능을 구현하고 html까지 적용하여 발전 시킬 예정이다. 이 프로젝트를 통해 배운 것을 복습하고 적용할 수 있어 유익한 시간이었다. 
<br>
<br>
😺임원재
<br>
이번 프로젝트를 하며 이전에 배운 스프링 부트와 REST API, MSA와 MyBatis, JPA 등을 직접 적용시키고 복습하며 개념을 다시 잡는 시간이 되었습니다.
특히 Spring Security에 대한 부족함과 필요성을 절실히 느끼게 되었습니다. 단순히 다른 사람의 코드만을 참조해 구현하려 하니 개념과 이해가 부족하여 로그인 기능 구현에 너무 많은 시간이 소요되었습니다. 이전에 제가 구현했던 NodeJS 서버와는 다르게 Spring Security가 많은 작업을 대신 해주고 저는 그 작업에 대해 필요한 설정들을 해줘야 합니다. 하지만 구동 원리의 이해가 없으니 활용은 사실상 불가능에 가까웠습니다. 아직 최종 프로젝트가 진행중인 만큼 개념을 확실히 잡고 구현에 들어가야할 필요성을 느꼈습니다.
<br>
두 번째, 공식 문서를 정독하는 것의 필요성을 느꼈습니다. 이는 전에 언급한바와 같이 개념을 공고히 하기 위해서입니다. 지하철을 탈 때, 자기 전, 쉬는 시간 등 여유있을 때 조금씩이라도 계속 제가 활용하는, 활용하고 싶은 것에 대해 기초부터 튼튼히 하는 시간을 가질 것입니다.
<br>
세 번째로, 기능 우선 주의에 대한 깨달음이 있었습니다. 구현할 당시 Spring Security가 제공하는 로그인 창이 뜨지 않았습니다. 저는 이 문제를 해결하겠다고 많은 시간을 할애하느라 정작 구현해야할 기능들은 차일피일 미뤄져만 갔습니다. 이에 많은 스트레스를 받은 시점에 현 상황에 해당 기능은 중요치 않다는 조언을 얻었고, REST한 서버를 구축할 예정이므로 해당 기능 또한 활용하지 않을 것이란 점을 깨달았습니다. 이미 포스트맨을 활용했을 땐 구현한 기능이 작동되므로 넘길 수 있었어야 했습니다. 앞으로의 개발 인생동안 현재 중요하고 우선적인 기능들을 명확히 하고 시간 분배를 하기 위해 노력할 것입니다.
<br>
배우기도 많이 배웠지만 아쉬운 점도 많은 시간이었습니다. 하지만 이런 점을 지금 배울 수 있게 되어 행복했습니다. 이번의 배움은 제가 개발자가 되는 길에 좋은 양분이 될 것입니다.
무엇보다 팀원들의 중요성과 감사함을 배웠습니다. 팀원들이 있기에 주저 앉지만 않는다면 더디더라도, 조금씩이라도 앞으로 나아갈 수 있었고 기간 동안 제가 버틸 수 있던 이유이기도 합니다. 이에 감사함을 잊지 않고 저 또한 팀원들이 의지할 수 있는 사람이 되기 위해 노력할 것입니다.
<br>
<br>
🐶정우진
<br>
저희 프로젝트를 통해 짧은 기간 동안 많은 것을 배웠습니다. 스프링 부트, MyBatis, Spring Data JPA, 그리고 REST API 등 수업 시간에 배웠던 내용을 실제로 활용해 보는 경험이었습니다. 이를 통해 기초를 좀 더 탄탄하게 다질 수 있었습니다. 또한, 이번 프로젝트에서 처음으로 DDD 설계를 도입하여 도메인을 설계하고, MSA를 적용하여 feign client, 유레카 서버, 클라이언트, 그리고 게이트웨이를 사용하여 데이터를 조회하는 경험도 했습니다.
<br>
협업을 위해 git과 GitHub을 사용하면서, 이를 통해 다른 팀원들의 코드를 보고 배울 수 있었습니다. 다른 팀원들의 코드를 보면서 '아, 이런 방식으로도 코드를 작성할 수 있구나'라는 생각이 들었습니다. 팀 프로젝트를 진행하면서 배운 것을 활용하고, 다른 코드도 보며 코드를 읽는 능력이 늘어난 것을 느낄 수 있었습니다. 앞으로 더 성장하여 더 나은 프로젝트를 만들기 위해 노력하겠습니다.
<br>
