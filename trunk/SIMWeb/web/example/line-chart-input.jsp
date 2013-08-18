<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<h3>Column Chart</h3>
<s:form namespace="line-chart" action="show" cssClass="well">
  <s:label value="Number of ecourses completed Actual vs Planned"/>
  <s:label value="2011"/> <s:textfield name="value1" /> 
  <s:label value="2012"/> <s:textfield name="value2" /> 
  <s:label value="2013"/> <s:textfield name="value3" /> 
  <s:label value="2014"/> <s:textfield name="value4" /> 
  <s:submit value="Update" cssClass="btn btn-primary"/>

</s:form>



