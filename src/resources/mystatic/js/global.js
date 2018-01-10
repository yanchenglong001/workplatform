define(['jquery'],function($){
    "use strict";// Javascript 严格模式use strict
    var _global = {
            getLocalPath:function(isAbsUrl){
                var curWwwPath = window.location.href;
                var pathName = window.location.pathname;
                var pos = curWwwPath.indexOf(pathName);
                var localhostPath = curWwwPath.substring(0,pos);
                var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
                return isAbsUrl?(localhostPath + projectName + '/'):'';
            },
            /**
             * @time  打印请求日志
             * @param showLog        是否显示日志
             * @param name           调用方法名
             * @param method         请求方式
             * @param url            请求地址
             * @param requestData    请求数据
             */
            consoleLogRequest:function(showLog,name,method,url,requestData){
                if(showLog){
                    console.log(name?name:'');
                    console.log('[[前台]]==>请求方式是');
                    console.log(method?method:'');
                    console.log('[[前台]]==>请求的url是');
                    console.log(url?url:'');
                    console.log('[[前台]]==>请求的数据是');
                    console.log(requestData?requestData:'');
                }
            },
            /**
             * @time  打印返回日志
             * @param showLog        是否显示日志
             * @param name           调用方法名
             * @param responseData   返回数据
             */
            consoleLogResponse:function(showLog,name,responseData){
                if(showLog){
                    console.log(name?name:'');
                    console.log('[[后台]]==>返回的数据是');
                    console.log(responseData?responseData:'');
                }
            },
            // 获取url中参数
            getUrlParams:function(){
                var _url = window.location.href;
                // 问号位置
                var _questionPlace = _url.indexOf('\?');
                var _param = false;
                if(_questionPlace!=-1){
                    // 截取字符串
                    _data=_url.substr(_questionPlace+1);
                    // 对字符串进行解密
                    _data=decodeURIComponent(_data);
                    // 获取数据对象
                    _data=JSON.parse(_data);
                }
                return _param;
            }
    };
    return _global;
});