<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/common.jsp"%>
<div class="layui-main">
 
<fieldset class="layui-elem-field layui-field-title">
  <legend>累计搜索网站</legend>
  <div class="layui-field-box">
    <div id="aaa" style="width: 400px;height:400px;float: left;"></div>
    <div id="bbb" style="width: 400px;height:400px;float: right;margin-right: 100px;"></div>
    <div id="ccc" style="width: 400px;height:400px;float: left;margin-right: 100px;"></div>
    <div id="ddd" style="width: 400px;height:400px;float: right;margin-right: 100px;"></div>
  </div>
</fieldset>
 <script type="text/javascript">
 
 var myChart = echarts.init($("#aaa")[0]);
 var myChart2 = echarts.init($("#bbb")[0]);
 var myChart3 = echarts.init($("#ccc")[0]);
 var myChart4 = echarts.init($("#ddd")[0]);
 var base = +new Date(1968, 9, 3);
 var oneDay = 24 * 3600 * 1000;
 var date = [];

 var data = [Math.random() * 300];

 for (var i = 1; i < 20000; i++) {
     var now = new Date(base += oneDay);
     date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
     data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
 }

 option = {
			    title: {
			        text: "某站点用户访问来源",
			        x: "center"
			    },
			    tooltip: {
			        trigger: "item",
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: "vertical",
			        x: "left",
			        data: ["直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎"]
			    },
			    toolbox: {
			        show: true,
			        feature: {
			            mark: {
			                show: true
			            },
			            dataView: {
			                show: true,
			                readOnly: true
			            },
			            restore: {
			                show: true
			            },
			            saveAsImage: {
			                show: true
			            }
			        }
			    },
			    calculable: true,
			    series: [
			        {
			            name: "访问来源",
			            type: "pie",
			            radius: "55%",
			            center: ["50%", "60%"],
			            data: [
			                {
			                    value: 335,
			                    name: "直接访问"
			                },
			                {
			                    value: 310,
			                    name: "邮件营销"
			                },
			                {
			                    value: 234,
			                    name: "联盟广告"
			                },
			                {
			                    value: 135,
			                    name: "视频广告"
			                },
			                {
			                    value: 1548,
			                    name: "搜索引擎"
			                }
			            ]
			        }
			    ]
 };
 
 option2 = {
		    title: {
		        text: "面积模式的南丁格尔玫瑰图",
		        x: "center"
		    },
		    tooltip: {
		        trigger: "item",
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        x: "center",
		        y: "bottom",
		        data: ["rose1", "rose2", "rose3", "rose4", "rose5", "rose6", "rose7", "rose8"]
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            mark: {
		                show: true
		            },
		            dataView: {
		                show: true,
		                readOnly: true
		            },
		            restore: {
		                show: true
		            },
		            saveAsImage: {
		                show: true
		            }
		        }
		    },
		    calculable: true,
		    series: [
		        {
		            name: "面积模式",
		            type: "pie",
		            radius: [30, 90],
		            center: ["50%", "50%"],
		            roseType: "area",
		            data: [
		                {
		                    value: 10,
		                    name: "rose1"
		                },
		                {
		                    value: 5,
		                    name: "rose2"
		                },
		                {
		                    value: 15,
		                    name: "rose3"
		                },
		                {
		                    value: 25,
		                    name: "rose4"
		                },
		                {
		                    value: 20,
		                    name: "rose5"
		                },
		                {
		                    value: 35,
		                    name: "rose6"
		                },
		                {
		                    value: 30,
		                    name: "rose7"
		                },
		                {
		                    value: 40,
		                    name: "rose8"
		                }
		            ]
		        }
		    ]
		}
 option3 = {
		 tooltip: {
		        formatter: "{a} <br/>{b} : {c}%"
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            mark: {
		                show: true
		            },
		            restore: {
		                show: true
		            },
		            saveAsImage: {
		                show: true
		            }
		        }
		    },
		    series: [
		        {
		            name: "业务指标",
		            type: "gauge",
		            detail: {
		                formatter: "{value}%"
		            },
		            data: [
		                {
		                    value: 50,
		                    name: "完成率"
		                }
		            ]
		        }
		    ]
 }
option4 = {
		 title: {
		        text: "\n某地区蒸发量和降水量",
		        x: "center"
		    },
		    tooltip: {
		        trigger: "axis"
		    },
		    legend: {
		        data: ["蒸发量", "降水量"]
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            mark: {
		                show: true
		            },
		            dataView: {
		                show: true,
		                readOnly: true
		            },
		            magicType: {
		                show: false,
		                type: ["line", "bar"]
		            },
		            restore: {
		                show: true
		            },
		            saveAsImage: {
		                show: true
		            }
		        }
		    },
		    calculable: true,
		    xAxis: [
		        {
		            type: "category",
		            data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
		        }
		    ],
		    yAxis: [
		        {
		            type: "value"
		        }
		    ],
		    series: [
		        {
		            name: "蒸发量",
		            type: "bar",
		            data: [2, 4.9, 7, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20, 6.4, 3.3]
		        },
		        {
		            name: "降水量",
		            type: "bar",
		            data: [2.6, 5.9, 9, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6, 2.3]
		        }
		    ]
 }
 myChart.setOption(option);
 myChart2.setOption(option2);
 myChart3.setOption(option3);
 myChart4.setOption(option4);

 </script>


</div>