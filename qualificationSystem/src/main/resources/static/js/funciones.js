function eliminar(id) {
	swal({
		title: "¿Estas seguro de eliminar este grado?",
		text: "Una vez eliminado, sus registros tambien lo harán",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminars/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("Se ha eliminado este grado", {
					icon: "success",
				}).then((ok)=>{
					location.href="/seccionesa";
				});
			} else {
				swal("Eliminacion cancelada");
			}
		});
}


// Eliminar Alumnos
function eliminarAl(id){
	swal({
		title: "¿Estas seguro de eliminar este alumno?",
		text: "Una vez eliminado, sus registros tambien lo harán",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarAL/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("Se ha eliminado este Alumno", {
					icon: "success",
				}).then((ok)=>{
					location.href="/alumnos";
				});
			} else {
				swal("Eliminación cancelada");
			}
		});
}

function eliminarAd(id){
	swal({
		title: "¿Estas seguro de eliminar este adminintrador?",
		text: "Una vez eliminado, sus registros tambien lo harán",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminaraad/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("Se ha eliminado este administrador", {
					icon: "success",
				}).then((ok)=>{
					location.href="/administradores";
				});
			} else {
				swal("Eliminación cancelada");
			}
		});
}

function eliminarMas(id){
	swal({
		title: "¿Estas seguro de eliminar este adminintrador?",
		text: "Una vez eliminado, sus registros tambien lo harán",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminaraad/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("Se ha eliminado este administrador", {
					icon: "success",
				}).then((ok)=>{
					location.href="/maestros";
				});
			} else {
				swal("Eliminación cancelada");
			}
		});
}


function eliminarMat(id){
	swal({
		title: "¿Estas Seguro de eliminar esta materia?",
		text: "Una vez eliminado, sus registros tambien lo harán",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarMat/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("Se ha eliminado este materia", {
					icon: "success",
				}).then((ok)=>{
					location.href="/materias";
				});
			} else {
				swal("Eliminacion cancelada");
			}
		});
}