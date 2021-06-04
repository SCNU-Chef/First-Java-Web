<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div  style="width: 1300px;height:400px;">
    	<table>
    		<th><h1>EasyMall 销售情况展示</h1></th>
    		<tr>
    			<td>
    				<div id="main1" style="width: 700px;height:500px;"></div>	
    			</td>
    			<td>
    				<div id="main2" style="width: 500px;height:500px;"></div>	
    			</td>
    		</tr>
    		<tr>
    		<td><a style="text-decoration:none;color:blue;font-size:30px" href="${pageContext.request.contextPath}/admin/print">打印报表</a></td>
    		<td><h2 style="color:red;font-size:30px">${print}</h2></td>
    		</tr>
    	</table>
    </div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('main1'));
        var myChart2 = echarts.init(document.getElementById('main2'));

        // 指定图表的配置项和数据
        var option1 = {
            title: {
                text : '销售数量'
            },
            tooltip: {},
            legend: {
                data : ['销量']
            },
            xAxis: {
            	type : 'category',
                data : ['爱疯9s','','滑雪套装','','banana','','金士顿内存条','','沙发','','宠物猫']
            },
            yAxis: {
            	name : '单位(件)',//坐标轴加单位
                type : 'value'
            },
            series: [{
            	itemStyle: {
                    normal: {
                        label: {
                            show: true,//柱顶端直接展示数字
                            position: 'top',
                            textStyle: {
                                color: '#800080'
                            }
                        }
                    }
                },
                name: '销量',
                type: 'bar',
                data: [3,,2,,5,,10,,3,,6]
            }]
        };
        
        var option2 = {
        		title: {
                    text : '销售占比'
                }, 
                series : [{
        			type: 'pie',    // 设置图表类型为饼图
                    radius: '65%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                    data:[          // 数据数组，name 为数据项名称，value 为数据项值
                        {value:3, name:'爱疯9s'},
                        {value:2, name:'滑雪套装'},
                        {value:5, name:'banana'},
                        {value:10, name:'金士顿内存条'},
                        {value:3, name:'沙发'},
                        {value:6, name:'宠物猫'}
                    ]
                }]
            };

        // 使用刚指定的配置项和数据显示图表。
        myChart1.setOption(option1);
        myChart2.setOption(option2);
    </script>