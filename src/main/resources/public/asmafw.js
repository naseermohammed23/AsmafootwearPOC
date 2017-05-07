$(document).ready(function() { 
	  var custDetails;// wait for document to fully load
	  var partyDetails;
	  
	  var today = new Date();
	  var dd = today.getDate();
	  var mm = today.getMonth()+1; //January is 0!
	  var yyyy = today.getFullYear();

	  if(dd<10) {
	      dd='0'+dd
	  } 

	  if(mm<10) {
	      mm='0'+mm
	  } 

	  today = dd+'/'+mm+'/'+yyyy;
	  $("#ds_date").html(today);
	  
	  
	  $("#getCustomer").click(function(event){ // capture a click on the button
         $.get(  // define a post method
            "http://localhost:8080/afwCustomer/customer",   // the url where info is going to be posted
            function(data) {  // callback function
            	var map = new Object();
            	custDetails = JSON.parse(JSON.stringify(data));
            	var i=0;
            	$('#custSelect').empty();
            	var option = '<option value="0">--Select--</option>';
            	for(i=0;i<custDetails.length;i++)
            	{
            		option += '<option value="'+ custDetails[i].id + '">' + custDetails[i].customerName + '</option>';
           		}
            	$('#custSelect').append(option);
         		
            }
         );
      });
	  
	  $("#getParty").click(function(event){ // capture a click on the button
	         $.get(  // define a post method
	            "http://localhost:8080/afwParty/party",   // the url where info is going to be posted
	            function(data) {  // callback function
	            	var map = new Object();
	            	partyDetails = JSON.parse(JSON.stringify(data));
	            	var i=0;
	            	$('#partySelect').empty();
	            	var option = '<option value="0">--Select--</option>';
	            	for(i=0;i<partyDetails.length;i++)
	            	{
	            		option += '<option value="'+ partyDetails[i].id + '">' + partyDetails[i].partyName + '</option>';
	           		}
	            	$('#partySelect').append(option);
	         		
	            }
	         );
	      });
      
   // wait for document to fully load
      $("#addCustomer").click(function(event){
    	  if( $("#customerName").val()=='' || $("#phoneNumber").val()=='' || $("#address").val()=='' || $("#balance").val()=='')
    		  {
    		  $("#cust_add_div").html("<p style='color:red'>Fields cannot be empty!</p>");
              setTimeout(function(){
              	 $("#cust_add_div").html("");
                  },2000);
              return;
    		  }
    	  
    	  var customer = {
    			  "customerName": $("#customerName").val(),
    			  "phoneNumber":$("#phoneNumber").val(),
    			  "address":$("#address").val(),
    			  "balance":$("#balance").val()
    	        }
    	 // alert(JSON.stringify(customer));
    	  $.ajax({
              url: 'http://localhost:8080/afwCustomer/customer',
              type: 'post',
              dataType: 'json',
              contentType: "application/json",
              success: function (data) {
                        $("#cust_add_div").html("<p style='color:green'>Customer Added Successfully!</p>");
                        setTimeout(function(){
                        	 $("#cust_add_div").html("");
                            },2000);  
                     $('#customerName').val("");
                   	 $('#phoneNumber').val("");
                   	 $('#address').val("");
                   	 $('#balance').val("");
              },
              data: JSON.stringify(customer)
          });
    	 
    	 
      });
      $("#addParty").click(function(event){
    	  var party = {
    			  "partyName": $("#partyName").val(),
    			  "phoneNumber":$("#partyPhoneNumber").val(),
    			  "address":$("#partyAddress").val(),
    			  "balance":$("#partyBalance").val()
    	        }
    	 // alert(JSON.stringify(customer));
    	  $.ajax({
              url: 'http://localhost:8080/afwParty/party',
              type: 'post',
              dataType: 'json',
              contentType: "application/json",
              success: function (data) {
            	     
            	  $("#party_new_div").html("<p style='color:green'>Party Added Successfully!</p>"); 
            	  setTimeout(function(){
                 	 $("#party_new_div").html("");
                     },2000);
            	  $("#partyName").val("");
            	  $("#partyPhoneNumber").val("");
            	  $("#partyAddress").val("");
            	  $("#partyBalance").val("");
            	 
              },
              data: JSON.stringify(party)
          });
      });
      
      $("#cust_add").click(function(event){
    	 if($("#g_custAmount").val()=='' ||  $("#g_custComments").val()=='' ||  $("#g_custName").val()=='' || $("#g_custPhone").val()=='' || $("#g_custAddr").val()=='' ||  $("#g_custBalance").val()=='')
    		 {
    		 $("#cust_history_div").html("<p style='color:red'>Fields cannot be empty!</p>");
             setTimeout(function(){
             	 $("#cust_history_div").html("");
                 },2000);
    		 return;
    		 }
    		
    	  var customerHistory = 
    		  {
    			  "historyId":$("#custSelect").val(),
    			  "amount":$("#g_custAmount").val(),
    			  "transactionType":"ADD",
    			  "comment":$("#g_custComments").val(),
    			  "userId":"1234"
    		  }
    	  $.ajax({
              url: 'http://localhost:8080/afwCustomerHistory/customerHistory',
              type: 'post',
              dataType: 'json',
              contentType: "application/json",
              success: function (data) {
            	  $("#cust_history_div").html("<p style='color:green'>Customer info updated!</p>"); 
            	  setTimeout(function(){
                 	 $("#cust_history_div").html("");
                     },2000);
            	  $("#g_custName").val("");
            	  $("#g_custPhone").val("");
            	  $("#g_custAddr").val("");
            	  $("#g_custBalance").val("");
            	  $("#g_custAmount").val("");
            	  $("#g_custComments").val("");
            	  
            	  },
              data: JSON.stringify(customerHistory)
          });
    	 
      });
      
      $("#cust_sub").click(function(event){
    	    	  
    	  var customerHistory = 
    		  {
    			  "historyId":$("#custSelect").val(),
    			  "amount":$("#g_custAmount").val(),
    			  "transactionType":"SUB",
    			  "comment":$("#g_custComments").val(),
    			  "userId":"1234"
    		  }
    	  $.ajax({
              url: 'http://localhost:8080/afwCustomerHistory/customerHistory',
              type: 'post',
              dataType: 'json',
              contentType: "application/json",
              success: function (data) {
            	  $("#cust_history_div").html("<p style='color:green'>Customer info updated!</p>"); 
            	  setTimeout(function(){
                 	 $("#cust_history_div").html("");
                     },2000);     
            	  $("#g_custName").val("");
            	  $("#g_custPhone").val("");
            	  $("#g_custAddr").val("");
            	  $("#g_custBalance").val("");
            	  $("#g_custAmount").val("");
            	  $("#g_custComments").val("");  
              },
              data: JSON.stringify(customerHistory)
          });
    	  
      });
      
      $("#gp_add").click(function(event){
     	 if($("#gp_partyName").val()=='' ||  $("#gp_phone").val()=='' ||  $("#gp_address").val()=='' || $("#gp_balance").val()=='' || $("#gp_amount").val()=='' ||  $("#gp_comment").val()=='')
     		 {
     		 $("#party_details_div").html("<p style='color:red'>Fields cannot be empty!</p>");
              setTimeout(function(){
              	 $("#party_details_div").html("");
                  },2000);
     		 return;
     		 }
     		
     	  var partyHistory = 
     		  {
     			  "historyId":$("#partySelect").val(),
     			  "amount":$("#gp_amount").val(),
     			  "transactionType":"ADD",
     			  "comment":$("#gp_comment").val(),
     			  "userId":"1234"
     		  }
     	  $.ajax({
               url: 'http://localhost:8080/afwPartyHistory/partyHistory',
               type: 'post',
               dataType: 'json',
               contentType: "application/json",
               success: function (data) {
             	  $("#party_details_div").html("<p style='color:green'>Customer info updated!</p>"); 
             	  setTimeout(function(){
                  	 $("#party_details_div").html("");
                      },2000);
             	  $("#gp_partyName").val("");
             	  $("#gp_phone").val("");
             	  $("#gp_address").val("");
             	  $("#gp_balance").val("");
             	  $("#gp_amount").val("");
             	  $("#gp_comment").val("");
             	  
             	  },
               data: JSON.stringify(partyHistory)
           });
     	 
       });
       
       $("#gp_sub").click(function(event){
     	    	  
    	 if($("#gp_partyName").val()=='' ||  $("#gp_phone").val()=='' ||  $("#gp_address").val()=='' || $("#gp_balance").val()=='' || $("#gp_amount").val()=='' ||  $("#gp_comment").val()=='')
   		 {
   		 $("#party_details_div").html("<p style='color:red'>Fields cannot be empty!</p>");
         setTimeout(function(){
            	 $("#party_details_div").html("");
                },2000);
   		 return;
   		 }
   		
   	  	var partyHistory = 
   		  {
   			  "historyId":$("#partySelect").val(),
   			  "amount":$("#gp_amount").val(),
   			  "transactionType":"SUB",
   			  "comment":$("#gp_comment").val(),
   			  "userId":"1234"
   		  }
     	  $.ajax({
               url: 'http://localhost:8080/afwPartyHistory/partyHistory',
               type: 'post',
               dataType: 'json',
               contentType: "application/json",
               success: function (data) {
            	   $("#party_details_div").html("<p style='color:green'>Customer info updated!</p>"); 
              	  setTimeout(function(){
                   	 $("#party_details_div").html("");
                       },2000);
              	  $("#gp_partyName").val("");
              	  $("#gp_phone").val("");
              	  $("#gp_address").val("");
              	  $("#gp_balance").val("");
              	  $("#gp_amount").val("");
              	  $("#gp_comment").val("");
               },
               data: JSON.stringify(partyHistory)
           });
     	  
       });
      
      $("#custSelect").change(function(){
    	  
    	  var selection=$(this).val();
    	  if(selection==0)
    		  {
    			$("#g_custName").val('');
			  	$("#g_custAddr").val('');
			  	$("#g_custBalance").val('');
			  	$("#g_custPhone").val('');
			  	$("#g_custAmount").val('');
			  	$("#g_custComments").val('');
    		  	return;
    		  }
    	$("#g_custAmount").val('');
   		$("#g_custComments").val('');
    	  var i=0;
    	  for(i=0;i<custDetails.length;i++)
    	  {
    		  if(custDetails[i].id==selection)
    			  {
    			  	$("#g_custName").val(custDetails[i].customerName);
    			  	$("#g_custAddr").val(custDetails[i].address);
    			  	$("#g_custBalance").val(custDetails[i].balance);
    			  	$("#g_custPhone").val(custDetails[i].phoneNumber);
    			  	
    			  }
    	  }
    	});
      
 	$("#partySelect").change(function(){
    	  
    	  var selection=$(this).val();
    	  if(selection==0)
    		  {
    		  $("#gp_partyName").val("");
          	  $("#gp_phone").val("");
          	  $("#gp_address").val("");
          	  $("#gp_balance").val("");
          	  $("#gp_amount").val("");
          	  $("#gp_comment").val("");
    		  	return;
    		  }
    	  $("#gp_amount").val("");
      	  $("#gp_comment").val("");
    	  var i=0;
    	  for(i=0;i<partyDetails.length;i++)
    	  {
    		  if(partyDetails[i].id==selection)
    			  {
    			  	$("#gp_partyName").val(partyDetails[i].partyName);
    			  	$("#gp_address").val(partyDetails[i].address);
    			  	$("#gp_balance").val(partyDetails[i].balance);
    			  	$("#gp_phone").val(partyDetails[i].phoneNumber);
    			  	
    			  }
    	  }
    	});
 	
 	 $("#ds_save").click(function(event){
     	 if($("#ds_saleAmount").val()=='' ||  $("#ds_expenses").val()=='' ||  $("#ds_profit").val()=='')
     		 {
     		 $("#ds_div").html("<p style='color:red'>Fields cannot be empty!</p>");
              setTimeout(function(){
              	 $("#ds_div").html("");
                  },2000);
     		 return;
     		 }
     		
     	  var dailySale = 
     		  {
     			  "salesAmount":$("#ds_saleAmount").val(),
     			  "expenses":$("#ds_expenses").val(),
     			  "profit":$("#ds_profit").val(),
     			  "userId":"1234"
     		  }
     	  alert(JSON.stringify(dailySale));
     	  $.ajax({
               url: 'http://localhost:8080/afwDailySale/dailySale',
               type: 'post',
               dataType: 'json',
               contentType: "application/json",
               success: function (data) {
             	  $("#ds_div").html("<p style='color:green'>Daily Sale info saved!</p>"); 
             	  setTimeout(function(){
                  	 $("#ds_div").html("");
                      },2000);
             	  $("#ds_saleAmount").val("");
             	  $("#ds_expenses").val("");
             	  $("#ds_profit").val("");
             	  },
               data: JSON.stringify(dailySale)
           });
     	 
       });
  });