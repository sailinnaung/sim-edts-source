<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<h3>Column Chart</h3>
<s:form namespace="pie-chart" action="show" cssClass="well">
  <s:label value="Number of ecourses completed per School"/>
  <s:label value="School of Business"/> <s:textfield name="value1" /> 
  <s:label value="School of Arts and Science"/> <s:textfield name="value2" /> 
  <s:label value="School of Science & Tech"/> <s:textfield name="value3" /> 
  <s:label value="School of Human Dev & Social service"/> <s:textfield name="value4" /> 
  <s:submit value="Update" cssClass="btn btn-primary"/>

</s:form>



