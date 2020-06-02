
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<script type="text/javascript">

    function a1() {
        $.ajax({
            url:"${pageContext.request.contextPath}/ajax/a1",
            data:{"name":$("#username").val()},
            type:"post",
            dataType: "json",
            success:function (data) {
                $("#ajax").html(data.msg);

            }
        });
    }
</script>

<script type="text/javascript">

    function a2() {
        $.ajax({
            url:"${pageContext.request.contextPath}/ajax/a2",
            data:{"name":$("#username").val(),"password":$("#userpassword").val()},
            type:"post",
            dataType: "json",
            success:function (data) {
                if(data.msg==true){
                    window.location.href = "${pageContext.request.contextPath}/user/login?name="+$("#username").val();
                }else{
                    alert("密码错误");
                }
            }
        });
    }
</script>


<a class="btn btn-default" href="${pageContext.request.contextPath}/book/allBooks"  role="button">Link</a>
<form class="form-horizontal"  method="post">
    <div class="form-group" >
        <label for="username" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input type="text"class="form-control" onblur="a1()"  name="name" id="username" placeholder="Name">
        </div>
    </div>
    <div class="form-group">
        <label for="userpassword" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control"  name="password" id="userpassword" placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <label id="ajax" class="col-sm-2 control-label"></label>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit"  onclick="a2()" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>
</body>
</html>

