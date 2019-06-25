<%@page import="com.example.model.SectionMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js">
</script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function removeDet() {
		var name = $('#test').val();
		try {
			$.ajax({
				type : 'GET',
				url : "ajax?&name=" + name,
				dataType : "html",
				success : function(data) {

					$("#serID").val(data);

				},
			});
		} catch (e) {
			alert(e)
		}
	}
	function getSection() {
		var name = $('#test').val();
		try {
			$.ajax({
				type : 'GET',
				url : "getSectionByClassTest?&studentClass=" + name,
				dataType : "html",
				success : function(data) {
					 
					
					$("#serIDtest").val(data);


				},
			});
		} catch (e) {
			alert(e)
		}
	}
	function calculateNet(discount) {
		var id = $('#studentId').val();
		var serID = $('#serID').val();
		var netamount = parseInt(serID) - parseInt(discount);
		$('#net').val(netamount);
		$("#errorBox").hide();

	}
	
	
	
	
	
	
     
     
</script>
<script type="text/javascript">
$(function() {

    $.widget('custom.mcautocomplete', $.ui.autocomplete, {
    	_create: function () {
            this._super();
            this.widget().menu("option", "items", "> :not(.ui-widget-header2)");
        },
        _renderMenu: function (ul, items) {
            var self = this,
                thead;
            if (this.options.showHeader) {
                table = $('<div class="ui-widget-header2" style=" width:100%;color:#583917 !important;background: linear-gradient(#B2BBC3 5%, #B2BBC3 120%)"></div>');
                $.each(this.options.columns, function (index, item) {
                    table.append('<span style="font-size:15px !important; padding:0 4px;float:left;width:' + item.width + ';">' + item.name + '</span>');
                });
                table.append('<div style="clear: both;"></div>');
                ul.append(table);
            }
            $.each(items, function (index, item) {
                self._renderItem(ul, item);
            });
        },
        _renderItem: function (ul, item) {
            var t = '',
                result = '';
            $.each(this.options.columns, function (index, column) {
                t += '<span align="left" style="font-size:12px;overflow-wrap: break-word;padding:0 4px;float:left;width:' + column.width + ';">' + item[column.valueField ? column.valueField : index] + '</span>'
            });
            result = $('<li ></li>')
                .data('ui-autocomplete-item', item)
                .append('<a class="mcacAnchor">' + t + '<div style="clear: both;"></div></a>')
                .appendTo(ul);
            return result;
        }
    });


    $(".bts").mcautocomplete({

       
	showHeader : true,
					columns : [ {
						name : 'SECTION',
						width : '120px',
						valueField : 'section',
					},
					
					
					
					],
					select : function(event, ui) {
					
						$("#test").val(ui.resp.section);
						
						return false;
					},
					minLength : 1,
					source : function(request, response) {
						var studentClass = $("#test").val();
					
	$.ajax({
							url : "getSectionByClassTest?&studentClass="
									+ studentClass.trim(),
							dataType : 'json',
							success : function(data) {
								var result;

								if (!data || data.length === 0
										|| !data.resp
										|| data.resp.length === 0) {

									result = [ {

									} ];
								} else {
									result = data.resp;

								}
								response(result);

							}
						});
					}
				});
	});
</script>





</head>
<body>
	<%
		String studentId = request.getParameter("studentId");
	     List<SectionMaster> sectionByClass=(List<SectionMaster>)request.getAttribute("sectionByClass");
	%>
	<form action="makeAdmissionWithFee" method="post">

		<table width="100%"
			style="background: border-bottom-width: 8px; border-left-width: 8px"
			frame="border" align="left">
			<tr>

				<td>&nbsp;&nbsp;&nbsp;</td>
			<tr align="left">
				<td align="left">STUDENT ID:<input type="text"
					value="<%=studentId%>" id="studentId" name="studentId"></td>
					<td>Avilable Sections:<input type="text"
					 id="serIDtest" ></td>
			</tr>



			<tr style="bgcolor: 4682B4" bordercolor="blue">


				<c:forEach items="${studentDetailsById}" var="dlist" >
					<tr>
						<td></td>
					<tr>

						<td>firstName:<c:out value="${dlist.firstName}" /></td>
						<td>lastName:<c:out value="${dlist.lastName}" /></td>
						<td>mobile:<c:out value="${dlist.mobile}" /></td>
						<td>AGE:<c:out value="${dlist.age}" /></td>
					</tr>


				</c:forEach>
				

			</tr>
			
			
			<tr>
				<td>STUDENTCLASS: <select name="studentClass" id="test"
					onchange="removeDet();getSection()"  >
						<option></option>
						<option value="0.1">play</option>
						<option value="0.2 ">L.K.G</option>
						<option value="0.3">U.K.G</option>
						<option value="1 ">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>

				</select>
			   

			</tr>
			<tr>
			
				<td nowrap="nowrap"><span>CLASS FEE:<input type="text" id="serID"
					name=classfee></span></td>
					<td nowrap="nowrap"><span>DISCOUNT:<input type="text" name=discount  id="discount"
					 onkeyup="calculateNet(this.value)"></span></td>
				<td>
				<!-- <td>DISCOUNT:<input type="text" name=discount  id="discount"
					 onkeyup="calculateNet(this.value)"></td> -->
				<td>finalAmount:<input type="text" name=finalAmount id="net">
				</td>
				
				
			</tr>
			<tr>
			<td>STUDENTSECTION:<input type="text" name="studentSection">
				
			</tr>
			
			<tr>
			<td align="center" colspan="3"><input type="submit"
					value="MAKE ADMISSION"></td>
			</tr>

		</table>



	</form>

</body>

</html>