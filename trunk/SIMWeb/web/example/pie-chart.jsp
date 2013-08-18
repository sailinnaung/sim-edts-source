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
          ['School', 'Num of completed eCourses'],
          ['School of Business', parseInt(value1)],
          ['School of Arts and Science',parseInt(value2)],
          ['School of Science & Tech', parseInt(value3)],
          ['School of Human Dev & Social service', parseInt(value4)]
        ]);

        var options = {
          title: 'E-Course Complete Report (School)'  
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

<h3>Pie Chart - eCourse Status per School</h3>
<div id="chart_div" style="width: 900px; height: 500px;"></div>



