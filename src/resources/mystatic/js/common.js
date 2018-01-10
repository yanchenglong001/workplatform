/** flat ui input错误css */
var CSS_HAS_ERROR = "has-error";

/**
 * 清除input 错误样式flat ui
 * @param el
 * @returns
 */
function clearErrCss(el){
    $(el).focus(function(){
        if($(this).parent().hasClass(CSS_HAS_ERROR)){
            $(this).parent().removeClass(CSS_HAS_ERROR);
        }
    });
}
/**
 * 设置input 错误样式 flat ui
 * @param el
 * @returns
 */
function addErrCss(el){
    
    $(el).addClass(CSS_HAS_ERROR);
    
}

function showMsg(msg,type,hideAfter,showCloseButton,hideOnNavigate){
    if(!type){
        type = "info";
    }
    if(!hideAfter){
        hideAfter = 1;
    }
    if(!showCloseButton){
        showCloseButton = true;
    }
    if(!hideOnNavigate){
        hideOnNavigate = true;
    }
    
    $.globalMessenger().post({
        message: msg,//提示信息
        type: type,//消息类型。error、info、success
        hideAfter: hideAfter,//多长时间消失
        showCloseButton:showCloseButton,//是否显示关闭按钮
        hideOnNavigate: hideOnNavigate //是否隐藏导航
    });
}

$(function(){
    $._messengerDefaults = {
            extraClasses: 'messenger-fixed messenger-theme-future messenger-on-bottom messenger-on-right'
    }
});