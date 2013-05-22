



function renderizaGridEntrada() {

    $('#datatable').dataTable({
        bProcessing: true,
        bServerSide: true,
        sAjaxSource: 'consulta/entrada',
        bPaginate: false,
        aoColumns: [
            {
                mData: 'titulo',
                sWidth: '400px'
            },
            {
                mData: 'fechaPublicacion',
                sType: "date",
                dateFormat: 'Date (dd-mm-YY)',
                sWidth: '100px',
                sClass: 'right',
                fnRender: function (obj) {
                    return obj.aData.fechaPublicacion.substring(0, 10);
                }
            }
        ]
    });
}