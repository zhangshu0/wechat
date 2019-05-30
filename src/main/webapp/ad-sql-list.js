define([
    '/client/widget/ui/utils/utils.js',
    '/client/widget/ui/form-handle/form-handle.js',
    "/client/widget/ui/dialog/dialog.js",
    '/client/widget/ui/pagination/pagination.js'
], function (Util,formHandle,Dialog) {
    var $mod = $('.page-sql-list');
    var $submit = $mod.find('.submit');// 提交按钮
    var $export = $mod.find('.export');
    var $exportNew=$mod.find('.exportNew');

    //查询用户名
    $submit.click('submit-data', function () {
        var sql = document.getElementById("sql").value;
        location.href = '/back/sql/executeSql.do?sql=' + sql;
    });

    //导出
    $export.click(function () {
        var sql = document.getElementById("sql").value;
        console.log(sql);
        var url =  "/back/sql/genSqlCSVFile.do";
        var data = {sql:sql};

        $.post(url,data,function(ret){

            if(ret && ret.status == 1){
                location.href = '/back/sql/exportCSV.do';
            }else{
                Dialog.tip("下载错误,"+ret.message);
            }

        },'json')

    });

    //导出
    $exportNew.click(function () {
        var sql = document.getElementById("sql").value;
        console.log(sql);
        var url =  "/back/sql/genFileNew.do";
        var data = {sql:sql};
        $.post(url,data,function(ret){
            if(ret && ret.status == 1){
                location.href = '/back/sql/export.do';
            }else{
                Dialog.tip("下载错误,"+ret.message);
            }

        },'json')

    });

});