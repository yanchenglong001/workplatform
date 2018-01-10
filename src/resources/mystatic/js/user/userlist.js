
    
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
        
        
    });

