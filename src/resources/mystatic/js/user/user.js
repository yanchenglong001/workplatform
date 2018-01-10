
    
    require.config({
        paths:{
            "jquery":"../jquery-1.7.2",            
            "bootstarp":"../../bootstrap/js/bootstrap.min",
            "messenger":"../../messenger/js/messenger",
            "global":"../global",
            "config":"../config",
            "nav":"../nav",
            "common":"../common"
            
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
    
    require(['jquery','messenger','common','config','nav'],function($,messenger,common,config,nav){
        // 初始化页面导航
        nav.init();
        // 
        function init(){
            
            if($("#method").val()=="register"){
                $("#divState").hide();
                $("#divValid").hide();
            }
            
        }
        init();
        // 设置获取焦点时清除错误消息
        clearErrCss($(".user-container input"));
        // 登录按钮设置
        $("#btnConfirm").click(function() {
            var loginId = $("#cLoginId").val();
            if (loginId == "") {
                addErrCss($("#cLoginId").parent());
                showMsg("登录名不能为空！","error");
                return;
            }
            var password = $("#cPassword").val();
            if (password == "") {
                addErrCss($("#cPassword").parent());
                showMsg("密码不能为空！","error");
                return;
            }
            
            var confirmPassword = $("#confirmPassword").val();
            if (password != confirmPassword) {
                addErrCss($("#cPassword").parent());
                showMsg("密码与确认密码不一致！","error");
                return;
            }
            
            $.ajax({
                type : config.methodPost,
                url : config.url.operUserUrl,
                data : {
                    "cLoginId" : $("#cLoginId").val(),
                    "cPassword" : $("#cPassword").val(),
                    "cName":$("#cName").val(),
                    "nState":$("input[name='nState']:checked").val(),
                    "nValid":$("input[name='nValid']:checked").val(),
                    "cId":$("#userId").val()
                },
                dataType : "json",
                success : function(data) {
                    if (!data.success) {
                        showMsg(data.msg,"error");
                        return;
                    }
                    // 设置获取焦点时清除错误消息
                    clearErrCss($(".user-container input"));
                    showMsg("操作成功","info");
                },
                error : function(data, textStatus, errorThrown) {
                    showMsg(textStatus,"error");
                }
            });
        });
    });

