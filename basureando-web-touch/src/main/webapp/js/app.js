Ext.application({
    launch: function() {

        Ext.Viewport.add({
            xtype: 'titlebar',
            items:[
                {
                    xtype: 'button',
                    ui: 'normal',
                    text: 'Saluda',
                    handler: saluda
                },
                {
                    xtype: 'button',
                    ui: 'normal',
                    text: 'Close',
                    handler: function() { }
                }
            ]
        });
    }
});


function saluda() {
    Ext.Msg.alert('Este es el título','Que tranza, que hay de nuevo?');
}