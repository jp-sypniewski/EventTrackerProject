window.addEventListener('load', function(){
  console.log("window event listener loaded");

  var xhr = new XMLHttpRequest();

  xhr.open('GET', 'api/teams/1/tasks', true);

  xhr.onreadystatechange = function() {

  	if (xhr.readyState === 4 && xhr.status < 400) {
  		var data = JSON.parse(xhr.responseText);
  		var initDiv = document.getElementById('init');
  		var ulTag = document.createElement('ul');
  		for (let i = 0; i < data.length; i++){
  			var liTag = document.createElement('li');
  			liTag.textContent = data[i].name;
  			ulTag.appendChild(liTag);
  		}
  		initDiv.appendChild(ulTag);
  		console.log(data);
  		
  	}

  	if (xhr.readyState === 4 && xhr.status >= 400) {
  		console.error(xhr.status + ': ' + xhr.responseText);
  	}
  	
  };

  xhr.send(null);

});