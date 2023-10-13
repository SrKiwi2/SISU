$(document).ready(function () {
    $('#miTabla').DataTable(); // Reemplaza 'miTabla' con el ID de tu tabla DataTable
});

$(document).ready(function () {
    $('.toggle-button').click(function () {
        var claveSpan = $(this).closest('tr').find('.clave');
        claveSpan.toggle();
    });
});

$(document).ready(function () {
    // Inicialización de DataTable
    $('#miTabla').DataTable();

    // Añade aquí tu código personalizado
    function gestionarMostrarOcultar() {
        $('.toggle-button').click(function () {
            var claveSpan = $(this).closest('tr').find('.clave');
            claveSpan.toggle();
        });
    }

    // Llama a tu función personalizada
    gestionarMostrarOcultar();
});



