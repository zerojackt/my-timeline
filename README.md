# my-timeline


- spring boot project




사용한 툴 : springboot, maven, jpa, mustache, h2 database, devtools, bootstrap, swagger2

<h3> 게시판 기능 </h3>

home : 처음 들어갈때 보이는 메인 페이지이다. <br/>
login and signup : 회원가입을하고 로그인을 할수있다. <br/>
timeline : post 에서 쓴글이 이쪽으로 보여진다 createDate,title,content,likeCount 로 이루어져있다. 작성된 글을 삭제할수있다. <br/>
profile : 자신의 profile 을 볼수있으면 그와 동시에 소개글, 사는 곳 을 작성할수있고 정보수정이 ( password 를 제외한) link 로 이동이 가능하다 <br/>
post : timeline 으로 보낼 글을 작성할수있는 form 이다. ( 날짜는 자동으로 등록된다 ) </br>
logout : session 에서 remove 됨으로 logout 되게 했다. </br>

</br>

<h2> 완성한 목표들 </h2>
</br>

1. signup and login
- >  success

2. logout and post
- > success
and use the ckeditor5, spring security lite ( only write the SecurityConfig.java )

3. profile and comments
- > profile success and editor profile
- > add likeCount ( id 당 클릭으로 처리되지 않음 ), post 를 delete 할수있는 delete button

4.



