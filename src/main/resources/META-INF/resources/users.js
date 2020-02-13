"use strict";
(function() {
	const datatable = $('#datatable');
	const databody = datatable.find('tbody');
	const crearDialog = $("#dialog-form");
	const fieldNombre = $("#nombre");
	const fieldEdad = $("#edad");
	const fieldEstatus = $("#estatus");

	function fillDatatable() {
		$.ajax({
			url : 'users',
			success : function(data, textStatus, jqXHR) {
				databody.empty();
				let length = data.length;
				for (let i = 0; i < length; i++) {
					let cur = data[i];
					databody.append('<tr><td>' + cur.id + '</td><td>'
							+ cur.nombre + '</td><td>' + cur.edad + '</td><td>'
							+ cur.fechaAlta + '</td><td>' + cur.estatus
							+ '</td></tr>')
				}
			}
		});
	}

	function addUser() {
		let info = {
			nombre : fieldNombre.val(),
			edad : fieldEdad.val(),
			estatus : fieldEstatus.val()
		};
		console.log(info);
		$.ajax({
			method : 'POST',
			url : 'users',
			contentType : 'application/json; charset=UTF-8',
			data : JSON.stringify(info)
		});
		crearDialog.dialog("close");
		fillDatatable();
	}

	$("#create-user").button().on("click", function() {
		crearDialog.dialog("open");
	});

	crearDialog.dialog({
		autoOpen : false,
		height : 400,
		width : 350,
		modal : true,
		buttons : {
			"Guardar" : addUser,
			Cancel : function() {
				crearDialog.dialog("close");
			}
		},
		close : function() {
			$('#formCreate')[0].reset();
		}
	});

	fillDatatable();
	return {};
})();
