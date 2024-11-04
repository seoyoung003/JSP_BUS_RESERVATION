<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>로그인</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Login_Registration.css" />
</head>
<body>
<div class="container">
  <div class="box signin">
    <h2>이미 계정이 있습니까?</h2>
    <button class="signinBtn">로그인</button>
  </div>
  <div class="formBx">
    <!-- 로그인 폼 -->
    <div class="form signinform">
      <form action="${pageContext.request.contextPath}/login" method="post">
        <h3>로그인</h3>
        <input type="text" name="username" placeholder="아이디를 입력해 주세요" required />
        <input type="password" name="password" placeholder="비밀번호를 입력해 주세요" required />
        <input type="submit" value="로그인" />
        <div class="find">
          <a href="#" class="forgot">아이디 찾기</a>
          <a href="#" class="forgot">비밀번호 찾기</a>
        </div>
        <!-- 로그인 에러 메시지
        <c:if test="${not empty loginError}">
          <div class="error">
            <p><c:out value="${loginError}"/></p>
          </div>
        </c:if> -->
      </form>
    </div>
  </div>
</div>
<script>
  const signinBtn = document.querySelector(".signinBtn");
  const body = document.querySelector("body");

  signinBtn.onclick = function () {
    // 추가적인 동작이 필요하면 여기에 작성
  };
</script>
</body>
</html>
