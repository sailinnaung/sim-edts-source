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
        var value5 = '<s:property value="value5" />';
        
        var data = google.visualization.arrayToDataTable([
          ['Year', 'E-course', 'E-Ready','SSTZ','ERAU','Others Z'],
          ['2012', parseInt(value1),parseInt(value2),parseInt(value3),parseInt(value4),parseInt(value5)],
          ['2013',26,44,7,24,6 ],
          ['2014', 43,60,8,32,10],
          ['2015', 59,73,8,39,13]
        ]);

        var options = {
          title: 'E-Course Complete Report (Year)',
          hAxis: {title: 'Year'}
		  
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

<h3>Column Chart - eCourse Status per Course</h3>
<div id="chart_div" style="width: 900px; height: 500px;"></div>



