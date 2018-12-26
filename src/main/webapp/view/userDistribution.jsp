<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById("showUserDistributionDiv"));
    option = {
        title : {
            text: '持明法洲APP用户分布图',
            subtext: '最新数据',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['用户数量']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name: '用户数量',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[]
            }

        ]
    };

    myChart.setOption(option);

    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/user/queryDistribution",
        dataType: "JSON",
        success: function (data) {
            // console.info(data);

            // $.each(data,function(index,distribution){
            //     console.info(distribution.name);
            //     console.info(distribution.value);
            // });
            // for(var key in data){
            //     console.log("name：" + key + ",value：" + data[key]);
            // }

            myChart.setOption({
                series: [
                    {
                    // 根据名字对应到相应的系列
                    name: '用户数量',
                    data: data
                    }

                ]
            })
        }
    });
</script>


<div id="showUserDistributionDiv" style="width: 700px;height:400px;"></div>