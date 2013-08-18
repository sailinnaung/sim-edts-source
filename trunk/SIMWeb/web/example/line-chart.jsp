<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
 <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var value1 = '<s:property value="value1" />';
        var value2 = '<s:property value="value2" />';
        var value3 = '<s:property value="value3" />';
        var value4 = '<s:property value="value4" />';
        
        
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Actual', 'Planned'],
          ['2011', parseInt(value1),10],
          ['2012',parseInt(value2), 10],
          ['2013', parseInt(value3),10],
          ['2014', parseInt(value4),10]
        ]);

        var options = {
          title: 'E-Course Status [Completed Vs Actual]'
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

<h3>Line Chart - eCourse Status [Completed vs Actual]</h3>
<div id="chart_div" style="width: 900px; height: 500px;"></div>



