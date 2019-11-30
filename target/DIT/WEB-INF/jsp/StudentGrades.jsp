<%-- 
    Document   : home
    Created on : Apr 22, 2019, 11:49:02 AM
    Author     : MS
--%>
<%@include file="login/header.jsp" %>
<fieldset>  <legend>ADD GPA</legend> 
      <form method='POST' id='dataFrom'> 
            <div class="row">
                <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden="">
                        <label>id</label>
                        <input type='text' name='id' id='id' class='form-control'/>
                  </div>
                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                        <label>name</label>
                        <input type='text' name='name' id='name' class='form-control'/>
                  </div>
                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                        <label>GPA</label>
                        <input type='text' name='gpa' id='gpa' class='form-control'/>
                  </div>

                  <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

                        <label id='ActionMSG'>&nbsp;</label><br>
                        <input type='button' onclick='doSave()' id='Save' value='Save' class='btn btn-success'/>
                        <input type='button' onclick='doUpdate()'  id='Update' value='Update' class='btn btn-success' style='display: none'/></div>
            </div>
      </form>
</fieldset> 

<br> <fieldset>  <legend>Details</legend> 
    <div class='row' id='table' ></div>
</fieldset>

<script>
    function edit(sn) {
        var id = ['id', 'name', 'gpa'];
        for (var i = 0; i < id.length; i++)
            document.getElementById(id[i]).value = document.getElementById("dataTable").rows[sn].cells.item(i).innerHTML;
        $('#Update').show();
        $('#Save').hide();
        document.getElementById('Update').focus();
    }
    
    function callApi(URL, requestData, apiMethod)
    {
        $('.btn').button('loading');
        var msg = '';
        $.ajax({type: apiMethod, url: URL, headers: {'Authorization': '<%=token%>'}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');
                if (!data['error']) {
                    msg = data['message'];
                    getRecord();
                    document.getElementById('dataFrom').reset();
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
        var URL = "<%=path%>/api/StudentGrades";
        callApi(URL, requestData, "POST");
    }
    
    function doUpdate()
    {
        var dataForm = $('form').serializeArray();
        var requestData = {};
        $.each(dataForm, function (i, v) {
            requestData[v.name] = v.value;
        });
        var URL = "<%=path%>/api/StudentGrades/" + document.getElementById('id').value;
        callApi(URL, requestData, "PUT");
    }
    
    function getRecord()
    {
        var URL = "<%=path%>/api/StudentGrades";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': '<%=token%>'}, contentType: "application/json; charset=utf-8", dataType: "json", success: function (data) {
                if (data.length == 0) {
                messages('Record Not Found');
                        document.getElementById('table').innerHTML = '';
                        return false;
                }
                document.getElementById('table').innerHTML = `<table class = 'table table-bordered table-hover table-striped' id = 'dataTable'><thead>
                        <tr><th hidden> id </th><th>Name</th><th> Grades </th><th>Action</th></tr></thead><tbody></tbody></table>`;
                        var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = "<tr><td hidden>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].gpa + "</td><td><a onclick='edit(" + (i + 1) + ")' class='glyphicon glyphicon-edit'></a> | <a onclick='recordDelete(" + data[i].fySymbol + ")' class='glyphicon glyphicon-remove-circle'></a></td></tr>";
                    $('#dataTable').append(tableData);
                }
            }
        });
    }
    
    function recordDelete(id) {
        if (!confirm('Are you sure'))
            return;
        var URL = "<%=path%>/api/StudentGrades/" + id;
        callApi(URL, "", "DELETE");
    }
    
    getRecord();



</script>
<%@include file="login/footer.jsp" %>
