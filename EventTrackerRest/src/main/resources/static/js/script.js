window.addEventListener('load', function(){
  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'api/teams/1/tasks', true);
  xhr.onreadystatechange = function() {
//	  api returns good
  	if (xhr.readyState === 4 && xhr.status < 400) {
  		var data = JSON.parse(xhr.responseText);
  		// get dedicated <div> for initialize
  		var initDiv = document.getElementById('init');
  		var table = document.createElement('table');
  		
  		var tableHead = document.createElement('thead');
  		var headRow = document.createElement('tr');
  		
  		var headName = document.createElement('th');
  		headName.textContent = "TASK";
  		headRow.appendChild(headName);
  		
  		var headStatus = document.createElement('th');
  		headStatus.textContent = "STATUS";
  		headRow.appendChild(headStatus);
  		
  		var headDueDate = document.createElement('th');
  		headDueDate.textContent = "DUE DATE";
  		headRow.appendChild(headDueDate);
  		
  		tableHead.appendChild(headRow);
  		table.appendChild(tableHead);
  		
  		
  		var tableBody = document.createElement('tbody');
  		
  		for (let i = 0; i < data.length; i++){
  			// create <tr> for each task with <td> for data
  			var tableRow = document.createElement('tr');
  			
  			var rowName = document.createElement('td');
  			rowName.textContent = data[i].name;
  			tableRow.appendChild(rowName);
  			
  			var rowStatus = document.createElement('td');
  			rowStatus.textContent = data[i].status;
  			tableRow.appendChild(rowStatus)
  			
  			var rowDue = document.createElement('td');
  			rowDue.textContent = data[i].dueDate;
  			tableRow.appendChild(rowDue);
  			
  			table.appendChild(tableRow);
  		}
  		table.appendChild(tableBody);
  		initDiv.appendChild(table);
  		console.log(data);	
  	}
//  	api returns bad
  	if (xhr.readyState === 4 && xhr.status >= 400) {
  		console.error(xhr.status + ': ' + xhr.responseText);
  	}	
  };
  xhr.send(null);
  

  
  
});

var myForm = document.getElementById("myForm");


console.log(myForm);


