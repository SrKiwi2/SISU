$(document).ready(function () {
    // Activar el modal al hacer clic en el botón "Editar"
    $("#editarButton").click(function () {
        var idPersona = $(this).data("idpersona");
        
        // Aquí puedes cargar los datos de la persona para editar
        // Puedes hacer una solicitud AJAX al servidor o cargar directamente los datos en el formulario del modal
        alert(idPersona+ "hola");
        // Por ejemplo, si deseas cargar los datos usando Thymeleaf, puedes hacer algo como esto:
        $.get("/obtenerPersona?idPersona=" + idPersona, function (data)  {

            alert(idPersona);
            // Llenar los campos del formulario del modal con los datos recibidos
            
            alert(data.nombres.val());
            console.log("Respuesta de la solicitud AJAX:", data);
            // Otros campos...
            
           
        });
    });
});