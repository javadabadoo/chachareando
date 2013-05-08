function getSysinfo(source) {
    var json = null;
    $.ajax({
        url: source,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            alert(data.alias);
        },
        error: function (request, status, error) {
            alert("REQUEST:\t" + request + "\nSTATUS:\t" + status +
                "\nERROR:\t" + error);
        }
    });
    return json;
}