$(document).ready(function(){
	listarAlumno();
	listarEscuela(0);
	//limpiar();
	//aLert("dsd");
});

$("#boton").click(function() {
			var cat = $("#cat").val();
			var nmc = $("#nmc").val();
			var cor = $("#cor").val();
			var tel = $("#tel").val();
			var id = $("#id").val();

			if (id == 0) {
				$.post("hc", {cat : cat,nmc : nmc,cor : cor,tel : tel, opc : 3}).done(function(data) {
					limpiar();
					listarEscuela(0);
					listarAlumno();
				});
			} else {
				bootbox.confirm("¿Desea Modificar?", function(result) {
					if (result) {
						bootbox.alert("¡Registro Modificado Correctamente!",
								function() {
									$.post("hc", {idesc : cat,nmc : nmc,cor : cor,tel : tel,idal : id,opc : 6}).done(function(data) {
										$("#id").val(0);
										limpiar();
										listarEscuela(0);
										listarAlumno();
									});
								});
					} else {
						bootbox.alert("El registro no se Modifico!");
						limpiar();
						listarEscuela(0);
						listarAlumno();
					}
				});

			}
		});

function listarEscuela(x){

	var i;
	$("#cat").empty().append('<option selected="selected" value="test">Seleccionar Escuela</option>');
	$.get("hc", {opc:"1"}, function(data){
		
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x==d[i].idescuela) {
				$("#cat").append('<option selected="selected" value="'+d[i].idescuela+'">'+d[i].nombre+'</option>');
			} else {
				$("#cat").append('<option value="'+d[i].idescuela+'">'+d[i].nombre+'</option>');
			}
		}
	});
}

function listarAlumno() {
	var i, c = 1;
	$.get("hc",{opc : "2"},function(data) {
		var d = JSON.parse(data);
		
		$('#tablita tbody').empty();
		for (var i = 0; i < d.length; i++) {
			$("#tablita tbody").append("<tr><td style='color:blue'>"+ c+ 
					"</td><td>"+ d[i].nombrecat+ "</td><td>"+ d[i].apelnombres+ "</td><td>"+ d[i].correo + "</td><td>"+ d[i].telefono
					+ "</td><td><a href='#' style='color:green' onclick='modificar(" + d[i].idalumno + ")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar(" + d[i].idalumno + ")'><i class='far fa-trash-alt'></i></a></td></tr>");
							c++;
						}
					});
}
function eliminar(id) {
	bootbox.confirm("¿Desea Eliminar?", function(result) {
		if (result) {
			bootbox.alert("Registro Eliminado Correctamente!", function() {
				$.get("hc", {id : id,opc : 5}, function(data) {
					limpiar();
					listarEscuela(0);
					listarAlumno();
				});
			});
		} else {
			bootbox.alert("El registro no se elimino!");
		}
	});
}
function modificar(id) {
	$.post("hc", {id : id,opc : 4}, function(data) {
		var x = JSON.parse(data);
		$("#nmc").val(x[0].apelnombres);
		$("#cor").val(x[0].correo);
		$("#tel").val(x[0].telefono);
		$("#id").val(x[0].idalumno);
		listarEscuela(x[0].idescuela);
	});
}
function limpiar(){
	$("#nmc").val("");
	$("#cor").val("");
	$("#tel").val("");
	$("#nmc").focus();
}
