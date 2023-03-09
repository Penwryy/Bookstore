<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>menu.html</title>	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <meta name="author" content="LiJin">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    <style>
        .aa{
            height: 32px;
            line-height:32px;
            margin:0 auto;
            width:150px;
            margin-bottom:12px;
            border:1px solid #b3d8ff;
            background: #ecf5ff;
            border-radius:6px;
        }
        .aa a{
            color:#409eff;
        }
    </style>
</head>
  
  <body style="text-align: center;background-color: #f0f9fd;">
   	<div style="text-align: center" class="div1">
<%--   		<h1 style="font-family:'KaiTi';">欢迎登陆三味书屋管理系统</h1>--%>
        <hr/>
        <div class="container-fluid">
            <div class="row" style="margin-left: 40px">
                <div class="col-sm-6">
                    <div id="priceChart" style="width: 600px;height:400px;"></div>
                </div>
                <div class="col-sm-6">
                    <div id="pressChart" style="width: 600px;height:400px;"></div>
                </div>
            </div>
        </div>
        <hr/>
        <div style="text-align: center" class="div1">
            <div class="aa">
                <a style="text-decoration: none;" href="${pageContext.request.contextPath }/book/selectBookByPage?page=1" target="Homepage">进入图书管理</a>
            </div>
        </div>
  	</div>
  </body>
</html>
<script>
    $.get('${pageContext.request.contextPath}/book/selectBookCountByPriceRange').done(function (data) {
        var priceChart = echarts.init(document.getElementById('priceChart'),'light');
        var option={
            title: {
                text: '各价位段图书数量'
            },
            tooltip: {},
            series : [
                {
                    name: '该价位段图书数量',
                    type: 'pie',
                    radius: '70%',
                    data:data
                }
            ]
        }
        // 使用刚指定的配置项和数据显示图表。
        priceChart.setOption(option);
    });
    $.get('${pageContext.request.contextPath}/book/selectBookCountByPress').done(function (data) {
        let titles=[];  //x轴上显示的数据
        let values=[]; //y轴上显示的数据
        for (let i = 0; i < data.length; i++) {
            titles[i] = data[i].press;
            values[i] = data[i].num;
        }
        var pressChart = echarts.init(document.getElementById('pressChart'),'light');
        var option = {
            title: {
                text: '各出版社图书数量'
            },
            tooltip: {},
            xAxis: {
                type: 'category',
                data: titles
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '该出版社图书数量',
                    data: values,
                    type: 'bar',
                    showBackground: true,
                    backgroundStyle: {
                        color: 'rgba(180, 180, 180, 0.2)'
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        pressChart.setOption(option);
    });
</script>
