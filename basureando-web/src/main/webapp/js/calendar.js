function Calendar (tbodyId, year, month) {
    this.tbodyId = tbodyId;
    this.year = year;
    this.month = month;
    this.dayList = null;
    this.firstDayPosition = 0;
    this.error = false;
    this.message = null;
}



Calendar.prototype.loadData = function(endpoint) {
    var data = consultaJson(endpoint + '/' + this.year + '/' + this.month, 'GET', null);
    this.endpoint = endpoint;
    this.dayList = data.daysOfMonth;
    this.firstDayPosition = data.firstDayPosition;
    this.error = data.error;
    this.message = data.message;
}



Calendar.prototype.populateCalendarGrid = function() {
    $(this.tbodyId).empty();

    var weekLimitIndex = (this.firstDayPosition - 1 + this.dayList.length) / 7;

    if(this.dayList.length / 7 != 0){
        weekLimitIndex++;
    }


    var trNode = null;
    for(var dayIndex = 0; dayIndex < this.dayList.length; dayIndex++) {

        if(dayIndex == 0 || (dayIndex + this.firstDayPosition - 1) % 7 == 0) {
            trNode = $('<tr>').appendTo($(this.tbodyId));
        }

        if(dayIndex == 0 && this.firstDayPosition > 1) {
            trNode.append('<td colspan="' + (this.firstDayPosition - 1) + '" class="pad"><span>&nbsp;</span></td>');
        }

        this.setCalendarDay(this.dayList[dayIndex], trNode);
    }
}



Calendar.prototype.setCalendarDay = function(currentDate, trNode) {
    var tdNode = $('<td>').appendTo(trNode);
    if(currentDate.active) {
        tdNode.append('<a href="' + this.endpoint + '/' + this.year + '/' + currentDate.day + '">' + currentDate.day + '</a>');
    } else {
        tdNode.append('<span>' + currentDate.day + '</span>');
    }
    trNode.append('</td>');
}

