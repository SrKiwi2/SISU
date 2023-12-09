function cargarInformacion() {
    // Obtener el valor del campo de entrada
    var codigoUniversitario = $("#validationCustom01").val();

    // Hacer la solicitud AJAX
    $.ajax({
        type: "GET",
        url: "/universitarioC",
        data: { codigoUniversitario: codigoUniversitario },
        success: function (data) {
            console.log("Respuesta exitosa", data);
            // Actualizar los campos del modal con los valores obtenidos
            if (data && data.nombreUniversitario){

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
                
                $("#myModal").modal("show"); 
            } else {
                console.error("Error en la solicitud AJAX", error);
                alert("No se encuentra datos válidos para el código univeritario proporcionado");
            }

            if (data.estadoMatriculacion == 'true') {
                $("#estadoMatriculacion").val("ACTIVO").css("color", "green");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton").text("Generar Ficha");
                $("#generarFichaButton").on("click", function(){

                    $.ajax({
                        type: "POST",
                        url: "/generarFichaCaja",
                        success: function (data){
                            console.log("FICHA GENERADA EXITOSAMENTE", data);
                        },
                        error: function (error) {
                            console.error("Error en Generar la Ficha", error);
                            alert("Error en Generar la Ficha. Consulta la consola para mas detalles")
                        }
                    })

                })
            } else {
                $("#estadoMatriculacion").val("INACTIVO").css("color", "red");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton").text("Generar Ficha Particular");
                $("#generarFichaButton").attr("formaction", "/A");  // Cambia "OtraAccion" por la acción deseada
            }
            
        },
        error: function(error) {
            console.error("Error en la solicitud AJAX", error)
            alert("Error en la solicitud AJAX. consulta la consola para más detalles");
            console.log(error);
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
            $("#gradoAcademicoD").val(data.gradoAcademicoD);
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
                $("#generarFichaButton2").text("Generar Ficha");
                $("#generarFichaButton2").on("click", function(){

                    $.ajax({
                        type: "POST",
                        url: "/generarFichaCaja",
                        success: function (data){
                            console.log("FICHA DOCENTE GENERADA EXITOSAMENTE", data);
                        },
                        error: function (error) {
                            console.error("Error en Generar la Ficha", error);
                            alert("Error en Generar la Ficha. Consulta la consola para mas detalles")
                        }
                    })

                })
            } else {
                $("#activo").val("INACTIVO").css("color", "red");
                // Cambiar el texto y la acción del botón en función del estado de matriculación
                $("#generarFichaButton2").text("Generar Ficha Particular");
                $("#generarFichaButton2").attr("formaction", "OtraAccion");  // Cambia "OtraAccion" por la acción deseada
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