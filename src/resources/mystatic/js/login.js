
    
    require.config({
        paths:{
            "jquery":"jquery-1.9.1",            
            "jquerymin":"../flatui/js/vendor/jquery.min",
            "flat-video":"../flatui/js/vendor/video",
            "flat-ui":"../flatui/js/flat-ui.min",
            "messenger":"../messenger/js/messenger",
            "global":"global",
            "config":"config",
            "common":"common"
            
        },
        shim:{
            'common':{
                deps:['jquery']
            },
            'messenger':{
                deps:['jquery']
            }
        }
    });
    require(['jquery','messenger','common','config'],function($,messenger,common,config){
        
        // 设置获取焦点时清除错误消息
        clearErrCss($(".loginform input"));
        // 登录按钮设置
        $("#btnLogin").click(function() {
            var loginId = $("#login-id").val();
            if (loginId == "") {
                addErrCss($("#login-id").parent());
                showMsg("用户名不能为空！","error");
                return;
            }
            var password = $("#login-pass").val();
            if (password == "") {
                addErrCss($("#login-pass").parent());
                showMsg("密码不能为空！","error");
                return;
            }

            $.ajax({
                type : config.methodPost,
                url : config.url.loginUrl,
                data : {
                    "cLoginId" : $("#login-id").val(),
                    "cPassword" : $("#login-pass").val()
                },
                dataType : "json",
                success : function(data) {
                    if (!data.success) {
                        addErrCss($("#login-id").parent());
                        addErrCss($("#login-pass").parent());
                        showMsg(data.msg,"error");
                        return;
                    }
                    location.href = config.url.indexUrl;
                },
                error : function(data, textStatus, errorThrown) {
                    showMsg(textStatus,"error");
                }
            });
        });
    });
    
    
    
    

//    $(".login-link").click(function() {
//
////        $.ajax({
////            type : "POST",
////            url : "/workplatform/user/addUser",
////            data : {
////                "loginId" : $("#login-id").val(),
////                "cPassword" : $("#login-pass").val()
////            },
////            dataType : "json",
////            success : function(data) {
////                if (!data.success) {
////                    alert(data.msg);
////                    return;
////                }
////            },
////            error : function(request, info, err) {
////                alert("info=" + info);
////            }
////        });
////
//        
//    });
      
