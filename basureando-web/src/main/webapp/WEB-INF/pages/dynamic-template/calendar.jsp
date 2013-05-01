<%--
  Created by IntelliJ IDEA.
  User: XM060EF
  Date: 12/07/13
--%>
<script type="text/javascript">
    $(document).ready(function() {
        var currentDate = new Date();
        var calendar = new Calendar(
                '#calendar-body',
                currentDate.getFullYear(),
                currentDate.getMonth() + 1
        );

        calendar.loadData('${pageContext.request.contextPath}/consult/calendar');
        calendar.populateCalendarGrid();
    });
</script>
<!-- Calendar -->
<section class="is-calendar">
    <div class="inner">
        <table>
            <caption>February 2013</caption>
            <thead>
            <tr>
                <th scope="col" title="Sunday">S</th>
                <th scope="col" title="Monday">M</th>
                <th scope="col" title="Tuesday">T</th>
                <th scope="col" title="Wednesday">W</th>
                <th scope="col" title="Thursday">T</th>
                <th scope="col" title="Friday">F</th>
                <th scope="col" title="Saturday">S</th>
            </tr>
            </thead>
            <tbody id="calendar-body">
            </tbody>
        </table>
    </div>
</section>