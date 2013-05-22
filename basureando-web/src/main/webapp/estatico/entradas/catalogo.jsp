<script type="text/javascript">
	var ajax_datatable;

	$(document).ready(function() {

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

	});
</script>

<h2>Entradas</h2>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="datatable">
	<thead>
		<tr>
			<th width="20%">T&iacute;tulo</th>
			<th width="25%">Fecha de publicaci&oacute;n</th>
		</tr>
	</thead>
	<tbody>

	</tbody>
	<tfoot>
		<tr>
			<th>T&iacute;tulo</th>
			<th>Fecha de publicaci&oacute;n</th>
		</tr>
	</tfoot>
</table>