<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <%@include file="common/head.jsp" %>
    <title>秒杀详情页</title>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>${seckill.name}</h1>
        </div>
        <div class="panel-body">
            <h2 class="text-danger">
                <!-- 显示timer 图标-->
                <span class="glyphicon glyphicon-time"></span>
                <!--显示倒计时-->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>
<!--登陆弹出层,输入电话-->
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="填手机号^o^" class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <!--验证信息-->
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- 通过CDN获取公共js http://www.bootcdn.cn -->
<!-- jQuery cookie 插件-->
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<!-- jQuery countdown 插件-->
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<!--开始编写交互逻辑-->
<script src="/resources/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        //使用 EL 表达式传入参数
        seckill.detail.init({
            seckillId: ${seckill.seckillId},
            startTime: ${seckill.startTime.time},//毫秒
            endTime: ${seckill.endTime.time}
        });
    });
</script>
</html>