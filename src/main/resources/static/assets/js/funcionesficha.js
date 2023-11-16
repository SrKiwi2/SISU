function cargarInformacion() {
    // Obtener el valor del campo de entrada
    var codigoUniversitario = $("#codigoUniversitarioInput").val();

    if (!codigoUniversitario){
        alert("Por favor, introduce un código universitario");
        return;
    }

    // Hacer la solicitud AJAX
    $.ajax({
        type: "GET",
        url: "/universitarioC",
        data: { codigoUniversitario: codigoUniversitario },
        success: function (data) {
            // Actualizar los campos del modal con los valores obtenidos
            $("#nombreUniversitario").val(data.nombreUniversitario);
            $('#apPaterno').val(data.apPaterno);
            $('#apMaterno').val(data.apMaterno)
            $("#ci").val(data.ci);
            $("#ru").val(data.ru);
            $("#fechaNacimiento").val(data.fechaNacimiento);
            $("#direccion").val(data.direccion);
            $("#correo").val(data.correo);
            $("#celular").val(data.celular);
            $("#carrera").val(data.carrera);
            $("#tipoSanguineo").val(data.tipoSanguineo);
            $("#sexo").val(data.sexo);

            if (data.estadoMatriculacion == 'true') {
                $("#estadoMatriculacion").val("ACTIVO").css("color", "green");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton").text("Generar Ficha");
                $("#generarFichaButton").attr("formaction", "Ficha");
            } else {
                $("#estadoMatriculacion").val("INACTIVO").css("color", "red");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton").text("Generar Ficha Particular");
                $("#generarFichaButton").attr("formaction", "OtraAccion");  // Cambia "OtraAccion" por la acción deseada
            }

            $('#myModal').modal('show');
        },
        error: function (error) {
            console.log("Error al cargar la información del universitario:", error);
        }
    });
    
}

function cargarInformacion2() {
    // Obtener el valor del campo de entrada
    var codigoDocente = $("#codigoDocenteInput").val();

    // Hacer la solicitud AJAX
    $.ajax({
        type: "GET",
        url: "/docenteC",
        data: { codigoDocente: codigoDocente },
        success: function (data) {
            // Actualizar los campos del modal con los valores obtenidos
            $("#DatosDocente").val(data.DatosDocente);
            $("#apellidoPaterno").val(data.apellidoPaterno);
            $("#apellidoMaterno").val(data.apellidoMaterno);
            $("#ciD").val(data.ci);
            $("#rd").val(data.rd);
            $("#gradoacademicoD").val(data.gradoacademicoD);
            $("#titulo").val(data.titulo);
            $("#fechaNacimientoD").val(data.fechaNacimiento);
            $("#tipoSanguineoD").val(data.tipoSanguineoD);
            $("#sexoD").val(data.sexo);
            $("#direccionD").val(data.direccion);
            $("#celularD").val(data.celular);
            $("#correoD").val(data.correo);
            $("#asignatura").val(data.asignatura);
            $("#tipoDocente").val(data.tipoDocente);
            $("#carrera").val(data.carrera);
            $("#facultad").val(data.facultad);

            if (data.activo == 'true') {
                $("#activo").val("ACTIVO").css("color", "green");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton").text("Generar Ficha");
                $("#generarFichaButton").attr("formaction", "Ficha");
            } else {
                $("#activo").val("INACTIVO").css("color", "red");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton").text("Generar Ficha Particular");
                $("#generarFichaButton").attr("formaction", "OtraAccion");  // Cambia "OtraAccion" por la acción deseada
            }
            // Otros campos...

            // Mostrar el modal
            $("#myModal2").modal("show");
        },
        error: function (error) {
            console.log("Error al cargar la información del universitario:", error);
        }
    });
}