
var datetime = null,
        date = null;

var update = function () {
    date = moment(new Date());
    datetime.html(date.format('HH:mm'));
    datetime2.html(date.format('dddd, LL'));
};

$(document).ready(function () {
    $("#menu-toggle").click(function(e) {
  e.preventDefault();
  $("wrapper").toggleClass("toggled");
    });
    moment.locale('es');
    datetime = $('.time h1');
    datetime2 = $('.time p');
    update();
    setInterval(update, 1000);
    
    $("#navInicio #inicio").addClass('active');
    $("#navCompras #compras").addClass('active');
    $("#navCaja #caja").addClass('active');
    $("#navInventario #inventario").addClass('active');
    $("#navContabilidad #contabilidad").addClass('active');
    $("#navTablas #tablas").addClass('active');
    $("#navCuentasPorPagar #cuentasPorPagar").addClass('active');
    $("#navSeguridad #seguridad").addClass('active');
});

function generarClienteProveedorPDF(){
	window.open("../tablas/tb_cliente_proveedor.xhtml");
        
}

function generarEmpleadoPDF(){
	window.open("../tablas/tb_empleados.xhtml");
        
}

function generarPersonarelaPDF(){
	window.open("../tablas/tb_personarela.xhtml");
        
}

function generarBancoPDF(){
	window.open("../tablas/tb_bancos.xhtml");
        
}


/**************************************************************
 * $("#navInicio #inicio").addClass('active');
 $("#navPerfil #perfil").addClass('active');
 $("#navAdmin #admin").addClass('active');
 $("#navMisProyectos #mis_proyectos").addClass('active');
 $("#navEntregaEquipos #entrega_equipos").addClass('active');
 $('#navVerPresupuesto #ver_presupuesto').addClass('active');
 $('#navDigitador #antiguos_proyectos').addClass('active');
 $('#navVerPersonal #ver_personal').addClass('active');
 $('#navGestionarProyectos #gestionar_proyectos').addClass('active');
 $('#navIndicadores #indicadores').addClass('active');
 $('#navConvocatoria #convocatoria').addClass('active');
 $('#navUnidad #unidad_investigacion').addClass('active');
 $('#navInvestigadores #investigadores').addClass('active');
 * 
 * 
 * 
 Máscara de entrada. Script creado por Tunait! (21/12/2004)
 Si quieres usar este script en tu sitio eres libre de hacerlo con la condición de que permanezcan intactas estas líneas, osea, los créditos.
 No autorizo a distribuír el código en sitios de script sin previa autorización
 Si quieres distribuírlo, por favor, contacta conmigo.
 Ver condiciones de uso en http://javascript.tunait.com/
 tunait@yahoo.com
 ****************************************************************/
