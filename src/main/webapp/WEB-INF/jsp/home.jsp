<%-- 
    Document   : home
    Created on : Apr 22, 2019, 11:49:02 AM
    Author     : MS
--%>
<%@include file="login/header.jsp" %>
<fieldset>  <legend>ADD DATA</legend> 
      <form method='POST' id='dataFrom'> 
            <div class="row">
                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                        <label>id</label>
                        <input type='text' name='id' id='id' class='form-control'/>
                  </div>
                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                        <label>name</label>
                        <input type='text' name='name' id='name' class='form-control'/>
                  </div>
                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                        <label>address</label>
                        <input type='text' name='address' id='address' class='form-control'/>
                  </div>

                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

                        <label id='ActionMSG'>&nbsp;</label><br>
                        <input type='button' onclick='doSave()' id='Save' value='Save' class='btn btn-success'/>
                        <!--<input type='button' onclick='doUpdate()'  id='Update' value='Update' class='btn btn-success' style='display: none'/></div>-->
            </div>
            </div>
      </form>

</fieldset> 
<script>

	function callApi(URL, requestData, apiMethod)
	{
		  $('.btn').button('loading');
		  var msg = '';
		  $.ajax({type: apiMethod, url: URL, headers: {'Authorization': '<%=token%>'}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8", dataType: "json",
			    success: function (data) {
					$('.btn').button('reset');
					if (!data['error']) {						 
						  msg = data['message'];						 
					
					} else {
						  msg = data['error'].message;
					}
					messages(msg);
					document.getElementById('msg').innerHTML = msg;
			    },
			    error: function (XMLHttpRequest, textStatus, errorThrown) {
					$('.btn').button('reset');
					messages(XMLHttpRequest + " Status: " + textStatus + " Error: " + errorThrown);
			    }});
	}

	function doSave()
	{
		  var dataForm = $('form').serializeArray();
		  var requestData = {};
		  $.each(dataForm, function (i, v) {
			    requestData[v.name] = v.value;
		  });
		  var URL = "<%=path%>/api/StudentInfo";
		  callApi(URL, requestData, "POST");
	}



</script>
<%@include file="login/footer.jsp" %>
