$(document).ready(function() {
    // Cuando se hace clic en el botón de edición
    $('.btn-primary[data-target=".bs-example-modal-center"]').on('click', function() {
        // Obtener el valor de data-idpersona
        var idPersona = $(this).data('idpersona');
        
        // Establecer el valor en el campo oculto
        $('#modal-idPersona').val(idPersona);
    });
    
    // Cuando se hace clic en el botón "Guardar" del modal
    $('#guardarButton').on('click', function() {
        var idPersona = $('#modal-idPersona').val();
        cargarDatosPersona(idPersona); 
    });
    
    function cargarDatosPersona(idPersona) {
        $.ajax({
            url: '/editarPersona/' + idPersona,
            method: 'GET',
            dataType: 'json', // Asegúrate de que los datos se devuelvan en formato JSON
            success: function(data) {
                // Llena los campos del formulario con los datos recuperados
                $('#nombre').val(data.nombres);
                $('#apellidoPaterno').val(data.apPaterno);
                $('#apellidoMaterno').val(data.apMaterno);
                $('#ci').val(data.ci);
                $('#genero').val(data.sexo);
                $('#direccion').val(data.direccion);
                $('#celular').val(data.celular);
                // Continúa llenando los demás campos según corresponda
            },
            error: function() {
                alert('Error al obtener los datos de la persona.');
            }
        });
    }
});
