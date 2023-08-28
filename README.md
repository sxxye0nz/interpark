# 소셜 커머스 인터파크 / 쇼핑몰 구현 팀 프로젝트
---
주 기능 구현
1. 로그인 및 회원가입 
-Security를 적용한 고객 회원가입과 로그인 기능 구현 및 권한 부여 
-회원 정보 비밀번호를 암호화하여 보안등급 활용
-DB를 이용한 사용자 권한 불러오기 구현
3. 관리자페이지 
-인덱스 페이지 슬라이드 상품등록 및 상품 목록 확인 가능 
-AWS Bucket 이용해 상품 사진 서버에 업로드관리자 페이지에서 카테고리별 상품등록 구현 
-등록한 상품 목록 확인 가능 
-SQL을 활용한 상품 CRUD 
4. 인덱스페이지 
-카테고리별 상품 목록 확인 가능 
-handler를 이용한 페이지 이동, 슬라이드 구현 
5. 사용자 페이지 
-상품 상세 페이지 확인 
-공지사항 게시판 페이지 구현 
-SQL을 활용한 게시판 CRUD
---
개발 목적
: back-end 개발자로서 front-end 개발자를 이해할 수 있는 full-stack 경험
: GIT TEAM 협업 관리
---
# to_do(공통)


- ~~비밀번호 암호화~~ 


- ~~로그인시 암호화된 비밀번호와 입력된 비밀번호 비교~~


-  ~~controller가 아닌 WebSecurityConfig로 로그인 하기 @Bean @Service 둘 중 하나만 사용하기~~

- 각종 CSS 디자인

---
### 정무

- 상품 글 쓰기: ~~회원만~~, AWS Bucket 이용해서 상품 사진 서버에 업로드(미구현)

- ~~상품리스트: 모든 회원/비회원 열람 가능(비회원 = '로그인' 버튼 활성화)~~

- 상품 글 수정/ 삭제: 작성자 OR 관리자만(미구현)

- ~~댓글시스템: 구현~~(조금 더 기능 추가? -> 대댓글?)

---
### 보경

- ~~green_member 테이블과 my_role 테이블 연결: 적절한 role 부여('ADMIN', 'USER', ... etc)~~

- ~~로그인 / 로그아웃 구현: 수정, 삭제 버튼 권한에 따라 노출~~

- ~~로그인, 회원가입페이지 css~~

- ~~handler 이용해서 페이지 이동 구현~~

- 비밀번호 확인 js 구현

---
### 소연
- ~~공지사항 게시판 페이지 : 관리자만 작성 가능~~
- ~~CRUD 중 게시글 조회, 등록~~
- ~~CRUD 중 게시글 수정, 삭제 완성~~
- ~~게시글 상세보기 페이지 구현 , 게시글 제목(title), 작성자(id), 내용(content), 작성일(created_date), 수정일(updated_date) 불러오기~~
---
🛠 Backend 개발 환경
| 기술스택 | 버전 |
| ------------ | ------------- |
| springframework.boot | 2.7.10 |
| java | 11 |
| CSS | 3 |
| HTML | 5 |
| Amazon Linux | 2 |
| Linux 커널 | 5.10.179-168.710.amzn2.x86_64 |
| apache-tomcat | 9.0.73 |
| Maria DB | 10.11 |
| Spring Security | 5.8.4 |
---
👏 API URL

#유저관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 회원가입 | /signup | get |
| 로그인 | /login | get |
| VIP 구독 | /sub | get |
| 로그아웃 | /logout | post |

#상품관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 작성 | /products-registration | get |
| 등록 | /products-save | post |
| 조회 | /products-list | get |
| 상세조회 | /products/{no} | get |

#메모관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 목록 | /mymemo-list | get |
| 작성 | /mymemo | get |
| 등록 | /mymemo | post |

| 조회 | /mymemo/{no} | get |
| 수정 | /mymemo/{no} | put |
| 삭제 | /mymemo/{no} | delete |

#게시글관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 작성 | /notice-write | get |
| 등록 | /notice-save | post |
| 조회 | /notice | get |
| 상세조회 | /notice/{no} | get |
| 수정 | /notice/{no} | put |
| 삭제 | /notice/{no} | delete |

#댓글관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 등록 | /reply/write | post |

---
💻ERD
![interpark](https://github.com/sxxye0nz/interpark/assets/105630255/281ea6fa-90a4-47b5-9206-7bc2ab1a4cf4)

