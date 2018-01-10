
require.config({
    paths:{
        "jquery":"jquery-1.7.2",
        "common":"common"
    }
});
require(['jquery'],function($){
    function test(){
        alert(11);
    }
    test();
});