$(function() {
	loadTable();
	pollServer();
});

function pollServer() {
    window.setTimeout(function () {
	    $.ajax({
	        url: "/api/animal/joined",
	        type: "GET",
	        dataType: 'json',
	        success: function (res) {
	            loadTable(res);
	            pollServer();
	        },
	        error: function () {
    			alert(thrownError);
	            pollServer();
	        }});
	}, 3000);
}

function loadTable() {
    $.ajax({
        url: "/api/animal/joined",
        type: "GET",
        dataType: 'json',
        success: function (animals) {
			let data = '';
			const t = document.querySelector('#animalTable');
			
			for (let animal of animals)
			{
				data += `<tr><td>${animal[0]}</td><td>${animal[1]}</td><td>${animal[2]}</td></tr>`;	
			}
			
			t.innerHTML = data;
        },
        error: function () {
			alert(thrownError);
        }
	});
}