<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById("showUserAnalyseDiv"));
    var option = {
        title: {
            text: "持明法洲APP活跃用户",
        },
        tooltip: {},
        legend: {
            type: "scroll",
            data: ["活跃人数"]
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: "活跃人数",
            type: 'bar',
            data: []
        }]
    };

    myChart.setOption(option);
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/user/queryAnalyse",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
				xAxis:{
				    data:data.intervals
				},
                series: [{
                    // 根据名字对应到相应的系列
                    name: '活跃人数',
                    data: data.data,
                    type:"bar"
                }]
            })
        }
    });
</script>


<div id="showUserAnalyseDiv" style="width: 700px;height:400px;"></div>