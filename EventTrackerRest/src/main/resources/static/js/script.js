window.addEventListener('load', function(){
  console.log("window event listener loaded");

  var xhr = new XMLHttpRequest();

  xhr.open('GET', 'api/teams/1/tasks', true);

  xhr.onreadystatechange = function() {
    console.log(xhr);


  	if (xhr.readyState === 4 && xhr.status < 400) {
  		var data = JSON.parse(xhr.responseText);
  		console.log(data);
  		
  	}

  	if (xhr.readyState === 4 && xhr.status >= 400) {
  		console.error(xhr.status + ': ' + xhr.responseText);
  	}
  };

  xhr.send(null);

});