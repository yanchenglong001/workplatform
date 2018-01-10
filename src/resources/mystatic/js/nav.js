define(['jquery','config'],
        function($,config){
           
            var nav = {
                    init:function (){
                        // 系统管理
                        if($("#nav_system_manage")){
                            $("#nav_system_manage").click(function(){
                                location.href=config.url.userUrl;
                            });
                            $("#nav_user_manage").click(function(){
                                location.href=config.url.userUrl;
                            });
                        }
                    }
            };
            
            return nav;
});