$(document).ready(function() {
    console.log("Document is ready!");
    // Cuando se hace clic en el botón de edición
    $('.btn-primary[data-target="#bs-example-modal-center"]').on('click', function() {
        // Obtener el valor de data-idpersona
        var idPersona = $(this).data('idpersona');
        alert(idPersona);
        
        // Establecer el valor en el campo oculto
        $('#modal-idPersona').val(idPersona);
        
        // Cargar datos de la persona en el formulario
        cargarDatosPersona(idPersona);
    });
    
    // Cuando se hace clic en el botón "Guardar" del modal
    $('#guardarPersona').on('click', function() {
        var idPersona = $('#modal-idPersona').val();
        guardarPersona(idPersona);
    });
    
    function cargarDatosPersona(idPersona) {
        $.ajax({
            url: '/editarPersona/' + idPersona,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                // Llena los campos del formulario con los datos recuperados
                $('#nombre1').val(data.nombres);
                $('#apellido1').val(data.apPaterno);
                $('#apellido2').val(data.apMaterno);
                $('#ci1').val(data.ci);
                $('#fechanac').val(data.fecha_nac);
                $('#sexo1').val(data.sexo);
                $('#estadocivil').val(data.tipos_estado_civil.estadoCivil)
                $('#celular1').val(data.celular);
                $('#direccion1').val(data.direccion);
                $('#grado1').val(data.grado_academico.gradoAcademico);
                $('#dip1').val(data.dip.codDip);
                
                // Continúa llenando los demás campos según corresponda
            },
            error: function() {
                alert('Error al obtener los datos de la persona.');
            }
        });
    }
    
    function guardarPersona(idPersona) {
        // Aquí debes implementar la lógica para guardar los datos de la persona editada.
        // Puedes usar una nueva solicitud AJAX para enviar los datos al servidor.
        // Asegúrate de manejar la respuesta del servidor y mostrar cualquier mensaje de éxito o error.
    }
});
