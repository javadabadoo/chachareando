



function renderizaGridEntrada() {

    $('#datatable').dataTable({
        bJQueryUI: true,
        bProcessing: true,
        bServerSide: true,
        sAjaxSource: 'consulta/entrada',
        bPaginate: false,
        aoColumns: [
            {
                mData: 'title',
                sWidth: '400px'
            },
            {
                mData: 'publicationDate',
                sType: "date",
                dateFormat: 'Date (dd-mm-YY)',
                sWidth: '100px',
                sClass: 'right',
                fnRender: function (obj) {
                    return obj.aData.publicationDate.substring(0, 10);
                }
            }
        ]
    });
}