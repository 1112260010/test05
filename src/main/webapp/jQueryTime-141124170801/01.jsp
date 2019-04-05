﻿<!DOCTYPE html PUBLIC >

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<title>简单实用蓝色jQuery日期选择插件 - 魔客吧</title>

<link href="css/lyz.calendar.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.8.2.min.js"></script>

<script src="js/lyz.calendar.min.js" type="text/javascript"></script>

<style>

body {

font-size: 12px;

font-family: "微软雅黑", "宋体", "Arial Narrow";

}

</style>

<script>

    $(function () {

        $("#txtBeginDate").calendar({

            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"

            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200

            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true

            readonly: true,                                       // 目标对象是否设为只读，默认：true

            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)

            lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)

            callback: function () {                               // 点击选择日期后的回调函数

                alert("您选择的日期是：" + $("#txtBeginDate").val());

            }

        });

        $("#txtEndDate").calendar();

    });

</script>

</head>

<body>

<div style="margin:200px auto; width:500px;">

  <input id="txtBeginDate" style="width:170px;padding:7px 10px;border:1px solid #ccc;margin-right:10px;"/>

  <input id="txtEndDate" style="width:170px;padding:7px 10px;border:1px solid #ccc;" />

</div>

</body>

</html>

