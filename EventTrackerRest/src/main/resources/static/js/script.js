var loadDetailView = function(e){
	var id = this.getAttribute("id");
//	this is the same as is loadAllTasks(), should refactor out
	var initDiv = document.getElementById('init');
	while (initDiv.firstElementChild){
		initDiv.removeChild(initDiv.firstElementChild);
	}
	
	var apiCallString = 'api/teams/1/tasks/' + id ;
	var xhr = new XMLHttpRequest();

	xhr.open('GET', apiCallString, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			var data = JSON.parse(xhr.responseText);
			
  			var taskName = document.createElement('h3');
  			taskName.textContent = "Task: " + data.name;
  			initDiv.appendChild(taskName);
  			
  			var taskStatus = document.createElement('h5');
  			taskStatus.textContent = "Status: " + data.status;
  			initDiv.appendChild(taskStatus)
  			
  			var rowDue = document.createElement('p');
  			rowDue.textContent = "Due: " + data.dueDate;
  			initDiv.appendChild(rowDue);
  			
  			var horRule = document.createElement('hr');
  			initDiv.appendChild(horRule);
  			
  	  		var tableHeader = document.createElement('h3');
  	  		tableHeader.textContent = "Update Task \"" + data.name + "\":"
  	  		initDiv.appendChild(tableHeader);

  			
  			
			var formForEditDelete = document.createElement('form');
			
			var formLabelTaskName = document.createElement('label');
			formLabelTaskName.setAttribute('for', 'name');
			formLabelTaskName.textContent = "Task name: ";
			formForEditDelete.appendChild(formLabelTaskName);
			
			var formTaskName = document.createElement('input');
			formTaskName.setAttribute('type', 'text');
			formTaskName.setAttribute('name', 'name');
			formForEditDelete.appendChild(formTaskName);
			
			var aBreak = document.createElement('br');
			formForEditDelete.appendChild(aBreak);
			
//			select dropdown
			
			var formLabelTaskStatus = document.createElement('label');
			formLabelTaskStatus.setAttribute('for', 'status');
			formLabelTaskStatus.textContent = "Status: ";
			formForEditDelete.appendChild(formLabelTaskStatus);
			
			
			var formTaskStatus = document.createElement('select');
			formTaskStatus.setAttribute('name', 'status');
			var optionOpen = document.createElement('option');
			optionOpen.setAttribute('value', 'open');
			optionOpen.textContent='Open';
			formTaskStatus.appendChild(optionOpen);
			var optionInProgress = document.createElement('option');
			optionInProgress.setAttribute('value', 'in_progress');
			optionInProgress.textContent='In Progress';
			formTaskStatus.appendChild(optionInProgress);
			var optionCompleted = document.createElement('option');
			optionCompleted.setAttribute('value', 'completed');
			optionCompleted.textContent='Completed';
			formTaskStatus.appendChild(optionCompleted);
			var optionAbandoned = document.createElement('option');
			optionAbandoned.setAttribute('value', 'abandoned');
			optionAbandoned.textContent='Abandoned';
			formTaskStatus.appendChild(optionAbandoned);
			formForEditDelete.appendChild(formTaskStatus);
			
			var aBreak = document.createElement('br');
			formForEditDelete.appendChild(aBreak);
			
			var formLabelTaskDueDate = document.createElement('label');
			formLabelTaskDueDate.setAttribute('for', 'dueDate');
			formLabelTaskDueDate.textContent = "Due date: ";
			formForEditDelete.appendChild(formLabelTaskDueDate);
			
			var formTaskDueDate = document.createElement('input');
			formTaskDueDate.setAttribute('type', 'datetime-local');
			formTaskDueDate.setAttribute('name', 'dueDate');
			formForEditDelete.appendChild(formTaskDueDate);
			
			var aBreak = document.createElement('br');
			formForEditDelete.appendChild(aBreak);

			
			var submitChangesButton = document.createElement('button');
			submitChangesButton.textContent = "Submit changes";
			formForEditDelete.appendChild(submitChangesButton);
			
			var aBreak = document.createElement('br');
			formForEditDelete.appendChild(aBreak);
			
//			add event listener to run PUT
			
  			var deleteButton = document.createElement('button');
  			deleteButton.textContent = "Delete " + data.name;
  			formForEditDelete.appendChild(deleteButton);
  			
//  		add event listener to run DELETE
  			
  			initDiv.appendChild(formForEditDelete);

  			
  			
  			
  			
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	};
	xhr.send(null);
};





var loadAllTasks = function(){
	var initDiv = document.getElementById('init');
	while (initDiv.firstElementChild){
		initDiv.removeChild(initDiv.firstElementChild);
	}

	
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/teams/1/tasks', true);
	xhr.onreadystatechange = function() {
//	  api returns good
  	if (xhr.readyState === 4 && xhr.status < 400) {
  		var data = JSON.parse(xhr.responseText);
  		// get dedicated <div> for tasks
  		
  		var tableHeader = document.createElement('h3');
  		tableHeader.textContent = "All Tasks:"
  		initDiv.appendChild(tableHeader);

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
  			tableRow.setAttribute("id", data[i].id);
  			tableRow.addEventListener('click', loadDetailView);
  			
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
  
};





window.addEventListener('load', loadAllTasks);

// load event listener for form.

document.taskForm.submit.addEventListener('click', function(e){
	e.preventDefault();
	var formReturn = e.target.parentElement;
	var taskObject = {
		name: formReturn.name.value,
		dueDate: formReturn.dueDate.value
	};
	var taskObjectJson = JSON.stringify(taskObject);
	
	
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/teams/1/tasks', true);

	xhr.setRequestHeader("Content-type", "application/json");
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 ) {
			if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
				var data = JSON.parse(xhr.responseText);
				loadAllTasks();
				console.log(data);
		    }
		    else {
		    	console.log("POST request failed.");
		    	console.error(xhr.status + ': ' + xhr.responseText);
		    }
		}
	};
	xhr.send(taskObjectJson);
	
});




