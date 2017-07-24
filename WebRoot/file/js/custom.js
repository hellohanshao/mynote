
$(function(){

	 $.contextMenu({
         selector: ".left .layui-nav-item" ,
         items: {
             "edit": {name: "编辑", callback: function(key, opt){
            		layer.prompt({title: '编辑', formType: 2},function(val, index){
          			  $.post(src+"/index/editorSubtitle.do",
          			   {  subtitle:val,
          				  relation:$("#active").val()
          			  },function(data){
          					  if(data.status==1){
          							alert("保存成功");
          						}else if(data.status==0){
          							alert("保存失败，请重试");
          						}
          					  layer.close(index);
          					  window.setTimeOut( window.location.href=window.location.href,500);
          				});
            		}) 
                 }
             },
             "note": {name: "新建笔记", callback: function(key, opt){
            			
            			var index = layer.open({
            				  type: 2,
            				  content:src+"/index/detail.do?subid="+$(this).attr('subid')+"&detailid=&id="+$(this).attr('id'),
            				  area: ['900px', '600px'],
            				  maxmin: true
            			});
            			
          		}
             },
             "new": {name: "新建标题", callback: function(key, opt){
            		layer.prompt({title: '新建标题', formType: 2},function(val, index){
            			  $.post(src+"/index/insertSubtitle.do",
            			   {  subtitle:val,
            				  relation:$("#active").val()
            			  },function(data){
            					  if(data.status==1){
            							alert("保存成功");
            						}else if(data.status==0){
            							alert("保存失败，请重试");
            						}
            					  layer.close(index);
            					  window.setTimeOut( window.location.href=window.location.href,500);
            				});
            		}) 
            	}
             },
             
            /* "newsub": {name: "新建子标题", 
            	 callback: function(key, opt){
             		layer.prompt({title: '新建子标题', formType: 2},function(val, index){
             			  $.post(src+"/index/newSubtitle.do",
             			   {  subtitle:val,
             				  relation:$("#active").val()
             			  },function(data){
             					  if(data.status==1){
             							alert("保存成功");
             						}else if(data.status==0){
             							alert("保存失败，请重试");
             						}
             					  layer.close(index);
             					  window.setTimeOut( window.location.href=window.location.href,500);
             				});
             		}) 
             	}
             },*/
             
             "delete": {name: "删除", 
            	 callback: function(key, opt){
            		 var subid = $(this).attr("subid");
            		 layer.msg('确定要删除？', {
            			  time: 0 //不自动关闭
            			  ,btn: ['确定', '取消']
            			  ,yes: function(index){

            				  $.post(src+"/index/deleteSubtitle.do",
                        			   {  id:subid
                        			  },function(data){
                        					  if(data.status==1){
                        							layer.msg("删除成功")
                        						}else if(data.status==0){
                        							layer.msg("删除失败")
                        						}
                        					  window.setTimeOut( window.location.href=window.location.href,500);
                        				});
            				  
            			    layer.close(index);
            			  }
            			});
            		 
             	}
             },
             
         }
     });


	 $.contextMenu({
         selector: ".left" ,
         items: {
             "note": {name: "新建笔记", callback: function(key, opt){
            			
            			var index = layer.open({
            				  type: 2,
            				  content:src+"/index/detail.do?subid=&detailid=&id="+id,
            				  area: ['900px', '600px'],
            				  maxmin: true
            			});
            			
          		}
             },
             "new": {name: "新建标题", callback: function(key, opt){
            		layer.prompt({title: '新建标题', formType: 2},function(val, index){
            			  $.post(src+"/index/insertSubtitle.do",
            			   {  subtitle:val,
            				  relation:$("#active").val()
            			  },function(data){
            					  if(data.status==1){
            							alert("保存成功");
            						}else if(data.status==0){
            							alert("保存失败，请重试");
            						}
            					  layer.close(index);
            					  window.setTimeOut( window.location.href=window.location.href,500);
            				});
            		}) 
            	}
             },
             
             
         }
     });
	 //openDetail
	 $.contextMenu({
         selector: ".openDetail" ,
         items: {
        	    "delete": {name: "删除", 
               	 callback: function(key, opt){
               		 var detailid = $(this).attr("detailid");
               		 layer.msg('确定要删除？', {
               			  time: 0 //不自动关闭
               			  ,btn: ['确定', '取消']
               			  ,yes: function(index){

               				  $.post(src+"/deleteDetail.do",
                           			   {  id:detailid
                           			  },function(data){
                           					  if(data.status==1){
                           							layer.msg("删除成功")
                           						}else if(data.status==0){
                           							layer.msg("删除失败")
                           						}
                           					  window.setTimeOut( window.location.href=window.location.href,500);
                           				});
               				  
               			    layer.close(index);
               			  }
               			});
               		 
                	}
                }
         }
     });
	 
	/* $(".detailajax").click(function(){
	$(this).css("color","red");
	var detailid = $(this).attr("detailid");
	var subid = $(this).attr("subid");
	var titleid = $(this).attr("titleid");
	$.get(src+"/index/detail.do",
		{subid:subid,id:titleid,detailid:detailid},
		function(data){
			$("#detailname").empty();
			$("#detailname").append(data.detailname);
				$("#detail").empty();
			$("#detail").append(data.detail); 
				alert($("#detail").val());
			//detail=data.detail;
		},"json");
	}); */

	/* 	$(".navbar-brand").click(function(){

	$("#setting").show();
	$("#nosetting").hide();


	});
	*/
	var openDetail;
	$(".openDetail").click(function(){
	
		    openDetail = layer.open({
			  type: 2,
			  content:src+"/index/detail.do?subid="+$(this).attr('subid')+"&detailid="+$(this).attr('detailid')+"&id="+$(this).attr('id'),
			  area: ['900px', '600px'],
			  maxmin: true
		});
	}) 
	//li:first-child
	/* $(".layui-nav-item").click(function(){
	if($(this).is("li.layui-nav-item.layui-nav-itemed")){
		$(this).removeClass("layui-nav-itemed");
	}else{
		$(this).addClass("layui-nav-itemed");
	}
	}) */
	$("#savedetail").click(function(){
		 		
		 		var detailid=0;
		 		var d = $("#detailname").attr("detailid");
		 		var url="";
		 			if($("#detailname").val()==""){
		 				alert("请输入标题内容后，再保存");
		 				return;
		 			}
		 		if(d=="undefined" || d==0 || d=="" || !d){
		 			url=	src+"/insertDetail.do";
		 		}else{
		 			detailid = $("#detailname").attr("detailid")
		 			
		 			url=	src+"/updateDetail.do";
		 		}
		 		
		 		var index = layer.load(0, {
					  shade: [0.1,'#fff'] //0.1透明度的白色背景
					 	
					});
				$.post(url,{detail:layedit.getContent(layindex),detailname:$.trim($("#detailname").val()),relation:$("#detailname").attr("relation"),id:detailid},function(data){
					if(data.status==1){
						alert("保存成功");
					 	layer.close(index);
					 	$("#detailname").attr("readonly");
					 	$("#detailarea").show();
					 	window.location.href=window.location.href;
					}else if(data.status==0){
						alert("保存失败，请重试");
						layer.close(index);
					}
				})
			}); 
			
			 $("#editor").on("click",function(){
				 $("#detailname").removeAttr("readonly");
				 $("#modifydetail").show();
				 $("#detailarea").hide();
				 
			}) ;

	$(".layui-box.layui-laypage.layui-laypage-default > a").click(function(){
		window.location.href=src+"/index/page.do?page="+$(this).attr("data-page")+"&subid="+$(this).attr("subid")+"&id="+$(this).attr("id");
		return false;
	})
/*	
var myChart = echarts.init($("#aaa")[0]);
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
    tooltip: {
        trigger: 'axis',
        position: function (pt) {
            return [pt[0], '10%'];
        }
    },
    title: {
        left: 'center',
        text: '大数据量面积图',
    },
    toolbox: {
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: date
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%']
    },
    dataZoom: [{
        type: 'inside',
        start: 0,
        end: 10
    }, {
        start: 0,
        end: 10,
        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
        handleSize: '80%',
        handleStyle: {
            color: '#fff',
            shadowBlur: 3,
            shadowColor: 'rgba(0, 0, 0, 0.6)',
            shadowOffsetX: 2,
            shadowOffsetY: 2
        }
    }],
    series: [
        {
            name:'模拟数据',
            type:'line',
            smooth:true,
            symbol: 'none',
            sampling: 'average',
            itemStyle: {
                normal: {
                    color: 'rgb(255, 70, 131)'
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgb(255, 158, 68)'
                    }, {
                        offset: 1,
                        color: 'rgb(255, 70, 131)'
                    }])
                }
            },
            data: data
        }
    ]
};
myChart.setOption(option);*/


})



