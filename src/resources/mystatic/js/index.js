
    
    require.config({
        paths:{
            "jquery":"jquery-1.9.1",            
            "bootstarp":"../bootstrap/js/bootstrap.min",
            "flat-ui":"../flatui/js/flat-ui.min",
            "messenger":"../messenger/js/messenger",
            "responsivenav":"../responsivenav/js/responsive-nav",
            "vue":"../vue/vue",
            "global":"global",
            "config":"config",
            "menu":"menu",
            "common":"common"
            
        },
        shim:{
            'common':{
                deps:['jquery']
            },
            'bootstarp':{
                deps:['jquery']
            },
            'messenger':{
                deps:['jquery']
            }
        }
    });
    require(['jquery','bootstarp','messenger','common','config','menu','responsivenav','vue'],
            function($,bootstarp,messenger,common,config,menu,responsivenav,Vue){
                menu.init();
                
                var app = new Vue({  el: '#app',  data: {     message: '页面加载于 ' + new Date().toLocaleString()  }});
                // 编辑用户
                $("#btnUser").click(function() {
                    showMsg("编辑用户","info");
                    var query = {
                            limit:15,
                            from:0,
                            fyid:[],
                            tjlx:'xs'
                    }
                    
                    query.fyid.push('000000');
                    var _data = JSON.parse(JSON.stringify(query));
                    $.ajax({
                        type:'get',
                        url:config.url.userUrl,
                        data:query,
                        dataType:"json",
                        success:function(data){
                            
                        },
                        error:function(data,textStatus,errorThrown){
                            alert(textStatus);
                        }
                    });
                });
                
                // 注销系统
                $("#btnLogout").click(function() {
                    location.href = config.url.logoutUrl;
                });
    });

