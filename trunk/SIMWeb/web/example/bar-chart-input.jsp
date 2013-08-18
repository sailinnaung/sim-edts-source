<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<h3>Column Chart</h3>
<s:form namespace="bar-chart" action="show" cssClass="well">
  <s:label value="Enter the vales for year 2012"/>
  <s:label value="Ecourse"/> <s:textfield name="value1" /> 
  <s:label value="EReady"/> <s:textfield name="value2" /> 
  <s:label value="Pilot Ready"/> <s:textfield name="value3" /> 
  <s:label value="ERAU"/> <s:textfield name="value4" /> 
  <s:submit value="Update" cssClass="btn btn-primary"/>

</s:form>



