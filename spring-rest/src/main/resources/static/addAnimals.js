// Map options in drop down to ids for POST
var specieMap = {}

$(function(){
	updateSpecies();
	updateEnclosures();
});

function updateSpecies() {
	$.ajax(
	{
  		url: "http://localhost:8080/api/specie",
    	type: 'GET',
    	dataType: 'json', 
		success: function(species) 
		{
			console.log(species);
			const list = document.querySelector('#specie');
			let data = '';
			for (let specie of species) {
				data += `<option>${specie.specieName}</option>`
				specieMap[specie.specieName] = specie.id;
			}
			list.innerHTML = data;
        },
		error: function(xhr, ajaxOptions, thrownError) 
		{
    		alert(xhr.status);
    		alert(thrownError);
  		}
	});
}

function updateEnclosures() {
	$.ajax(
	{
  		url: "http://localhost:8080/api/animal-enclosure",
    	type: 'GET',
    	dataType: 'json', 
		success: function(enclosures) 
		{
			const list = document.querySelector('#enclosure');
			let data = '';
			for (let enclosure of enclosures) {
				data += `<option>#${enclosure.id}: ${enclosure.enclosure.enclosureType}</option>`
			}
			list.innerHTML = data;
        },
		error: function(xhr, ajaxOptions, thrownError) 
		{
    		alert(xhr.status);
    		alert(thrownError);
  		}
	});
}

function add() {
	var data = 
	{
		"name": document.querySelector('#name').value,
		"specie_id": specieMap[document.querySelector('#specie').value],
		"enc_id": parseInt(document.querySelector('#enclosure').value[1])
	};
	console.log(data);
	$.ajax({
		url: "http://localhost:8080/api/animal",
		type: 'POST',
		data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: function(res) 
        {
			console.log(res);
			console.log("Success.");
		}
	});
}