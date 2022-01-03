<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="utf-8" />
		<title>宋账本</title>
		<meta http-equiv="pragma" content="no-cache"/>   
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>   
		<meta http-equiv="expires" content="0"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> 
		<link href="${pageContext.request.contextPath}/static/bootstrap3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<%@include file="./css_zhangzu.jsp" %>
	</head>
	
	<body>
		<%@include file="./logo.jsp" %>
		
		<div class="container">
			
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							统计分析
							
						</small>
					</h1>
				</div>
				<br/>
				<div id="columnchart_material" style="width: 100%; height: 500px;"></div>
				<br/>
				<br/>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							
							<div class="form-group">
								<label class="col-sm-2 control-label">账单年月：</label>
								<div class="col-sm-10">
									<select class="form-control" id="zhangzu_ac" name="zhangzu_ac" >
									  <option value="2022/01">2022/01</option>

									</select>
								</div>

							</div>
							<div class="form-group">
								<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr >
										<!--
										<th width="5%">ID</th>
										-->
										<th width="20%">年月</th>
										<th width="20%">支出</th>
										<th width="20%">收入</th>
										<th width="20%">余额</th>0
										<th width="20%">买货</th>
>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list_zz_analysis}"  var="zz_analysis"  >
								
									<tr >

									
										<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<!--
										<td>${zhangzu.id}</td>
										-->
										<td>${zz_analysis.ac}</td>
										<td><a href='${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?AC=${zz_analysis.ac}&IO=MIN'>${zz_analysis.ac_min}</a></td>
										<td><a href='${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?AC=${zz_analysis.ac}&IO=PLUS'>${zz_analysis.ac_plus}</a></td>
										<td>${zz_analysis.ac_result}</td>
										<td><a href='${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?AC=${zz_analysis.ac}&IO=MAIHUO'>${zz_analysis.ac_maihuo}</td>

										
									</tr>
								</c:forEach>

								
								
								</tbody>
							</table>
						</div>
						
						
						
							<div class="form-group">
								<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr >
										<!--
										<th width="5%">ID</th>
										-->
										<th width="33%">年月</th>
										<th width="33%">支出</th>
										<th width="33%">分类</th>
										
>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list_zz_type_analysis}"  var="zz_analysis"  >
								
									<tr >

									
										<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<!--
										<td>${zhangzu.id}</td>
										-->
										<td>${zz_analysis.ac}</td>
										<td><a href='https://www.plseal.com:8090/index_for_analysis?AC=${zz_analysis.ac}&IO=MIN&AC_TYPE=${zz_analysis.ac_type}'>${zz_analysis.ac_min}</td>
										<td>${zz_analysis.ac_type}</td>
										
										
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
<script type="text/javascript">
		
window.onload=function(){
	<c:forEach items="${list_zz_analysis}"  var="zz_analysis"  >
		$("#zhangzu_ac").val("${zz_analysis.ac}");
	</c:forEach>
}

$(document).ready(function(){ 
	$('#zhangzu_ac').change(function(){ 
		//alert($(this).children('option:selected').val()); 
		var p1=$(this).children('option:selected').val();
		 
		
		window.location.href = "<%=request.getContextPath() %>/zhangzu/to_zhangzu_analysis_2022.do?zhangzu_ac="+p1;
	}) 
}) 
			
</script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Month', '支出', '收入', '余额', '买货'],
		<c:forEach items="${list_2022_zz_analysis}"  var="zz_analysis"  varStatus="status">
		
				['${zz_analysis.ac}', ${zz_analysis.ac_min}, ${zz_analysis.ac_plus}, ${zz_analysis.ac_result},${zz_analysis.ac_maihuo}]<c:if test="${not (status.count eq listSize)}">,</c:if>

		</c:forEach>
				//['2020/01', 139724, 396398, 256674,0],
				//['2020/02', 299392, 145246, -154146,0],
				//['2020/03', 560947, 549570, -11377,239393],
				//['2020/04', 371730, 396398, 24668,79976]



        ]);

        var options = {
          chart: {
            title: '2022',
            //subtitle: '201701-201712',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
		
		
		// Add our selection handler.
		google.visualization.events.addListener(chart, 'select', selectHandler);

		// The selection handler.
		// Loop through all items in the selection and concatenate
		// a single message from all of them.
		function selectHandler() {
		  var selection = chart.getSelection();
		  var message = '';
		  for (var i = 0; i < selection.length; i++) {
			var item = selection[i];
			if (item.row != null && item.column != null) {
			  //var str_ac = data.getFormattedValue(item.row, item.column);
			  var str_ac = data.getFormattedValue(item.row, 0);
			  message += '{row1:' + item.row + ',column:' + item.column + '} = ' + str_ac + '\n';
			  
			  //ZHICHU
			  if (item.column == 1) {
				window.location.href = "/Blog/zhangzu/to_zhangzu_analysis_2022.do?zhangzu_ac="+str_ac;
			  }
			} else if (item.row != null) {
			  var str_ac = data.getFormattedValue(item.row, 0);
			  message += '{row2:' + item.row + ', column:none}; value (col 0) = ' + str_ac + '\n';
			} else if (item.column != null) {
			  var str_ac = data.getFormattedValue(0, item.column);
			  message += '{row3:none, column:' + item.column + '}; value (row 0) = ' + str_ac + '\n';
			}
		  }
		  if (message == '') {
			message = 'nothing';
		  }
		  //alert('You selected ' + message);
		  
		}
		
		
      }
    </script>
</div>
</body>
</html>