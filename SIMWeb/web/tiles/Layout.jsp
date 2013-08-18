<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
    <link href="<s:url value="/css/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
    <script src="<s:url value="/css/bootstrap/js/bootstrap.js"/>"></script>
    <script src="http://code.jquery.com/jquery.js"></script>\
    <script type="text/javascript" src="<s:url value="/js/googleapi.js"/>"></script>
  </head>
  <body>
    <tiles:insertAttribute name="header"/>
    <div class="page">
      <div class="row">
        <div class="span3">
          <tiles:insertAttribute name="first-sidebar"/>
        </div>
        <div class="span9">
          <tiles:insertAttribute name="body"/>
        </div>
      </div>
    </div>

    <div class="footer"> 
      <table width="100%">
        <tr>
          <td width="100%">
            <tiles:insertAttribute name="footer"/>
          </td>
        </tr>
      </table>

    </div>

  </body>
</html>