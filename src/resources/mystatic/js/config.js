define(['global'],function(global){
    // true：获取项目绝对路径地址，false：相对路径地址
    var getLocalPath = global.getLocalPath(true);
    var rootFolder = '..';
    var config = {
            isDebug:false,// true：为json数据，false：为服务器数据
            methodGet:'get',//
            methodPost:'post',//
            url:{},// 数据地址
            showLog:false,// 是否显示日志
            dirJsonPath: getLocalPath + rootFolder +'/json/'
    };
    
    var localUrl = {
            loginUrl:config.dirJsonPath + 'login.json',
            logoutUrl:'login.html',
            indexUrl:'index.html',
            showUserUrl:'user/userlist.html',
            userUrl:'user/userlist.html',
            operUserUrl:'user/user.html'
    };
    
    var serverUrl = {
            loginUrl:'/workplatform/login/dologin',
            logoutUrl:'/workplatform/login/logout',
            indexUrl:'/workplatform/index/index',
            showUserUrl:'/workplatform/user/user',
            userUrl:'/workplatform/user/userlist',
            operUserUrl:'/workplatform/user/user'
    };
    config.url = config.isDebug ? localUrl:serverUrl;
    
    return config;
});