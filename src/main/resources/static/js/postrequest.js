
$( document ).ready(function() 
{// SUBMIT FORM
    $("#register").click(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
	function ajaxPost(){
		var currentdata='';
		var formData = {
			firstName : $("#fname").val(),
			lastName : $("#lname").val(),
			emailId : $("#email").val(),
			dateOfBirth : $("#dob").val(),
			gender : $("input:radio[name=optradio]:checked").val(),
			phoneNumber : $("#pno").val(),
			address : $("#address").val()		
    	}
		// DO POST
    	$.ajax(
		{
			type : "POST",
			contentType : "application/json",
			url :"http://localhost:8081/emp/save",
			data : JSON.stringify(formData),
			dataType : 'json',		
			result: "{}",
			success : function(result) {
					   /* $.each(result.employeeRecords, function(index, data) {*/
	                          var trHTML = '';

	                          for (var i = 0; i < tst.length; i++){
	                            console.log(tst[i]);
	                            trHTML += '<tr><td><input type="checkbox" />&nbsp; </td><td>' + tst[i].emdId + '</td><td>' +tst[i].firstName + '</td><td>' + tst[i].lastName + '</td><td>' + tst[i].emailId + '</td><td>' + tst[i].dateOfBirth + '</td><td>' + tst[i].phoneNumber + '</td><td>' + tst[i].gender + '</td><td>' + tst[i].address + '</td><td><button type="button" class="btn btn-primary" id="Edit">Edit</button></td></tr>';
	                         console.log(trHTML);
	                          }               
	                          $('#myTable').append(trHTML);               
					    /*});*/
					  
			if(result.status == "true"){
				alert(result['message']);
				 loadData(result);
	                $('#conCode').html(result);
			}
			else{
				alert(result['message']);
			}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				$("#idv").html(result.response.status);
				console.log("ERROR: ", "email already exists please insert new email.!");
			}
		});
	
    }
    
	function loadData(datas){
        var sb = '';
        var table = $('#tableBody');
        $('#json').show();
        $('#table').show();
        table.html('');

        $.each(datas, function(index, emp){
            sb += '<tr>';
            sb += '    <td>' + emp.emdId + '</td>';
            sb += '    <td>' + emp.firstName + '</td>';
            sb += '    <td>' + emp.lastName + '</td>';
            sb += '    <td>' + emp.emailId + '</td>';
            sb += '</tr>';
        });

        table.append(sb);
    }
    function resetData(){
    	$("#fname").val("");
    	$("#lname").val("");
		$("#email").val("");
		$("#datepicker").val("");
		$("#lname").val("");
		$("#pno").val("");
		$("#address").val("");
    }
})