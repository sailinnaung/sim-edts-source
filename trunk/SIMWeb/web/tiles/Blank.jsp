<%@ page contentType="text/html"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

  <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="coms.maintitle"/></title>
         <s:form namespace="/user" action="messageread" method="post">
        
       <br/><br/>

<table width="100%" class="borderAll">
  <tr>
  <th><s:text name="label.event.message"/></th>
  
  <th>&nbsp;</th>
</tr>
<s:iterator value="events" status="conf">
  <tr class="<s:if test="#conf.odd == true">odd</s:if><s:else>even</s:else>">
  <td class="nowrap"><s:property value="message"/></td>
  
  <td class="nowrap">
   <s:checkbox name="readevent" fieldValue="%{eventId}" value="%{eventId}" />
  </td>
</tr>
</s:iterator>
</table>
        <table width="100%">
            <tr align="center" valign="middle">
                <td colspan="2" align="center">
                    <!-- Step 4. Design a submit and reset buttons of Style "butStnd" from master.css file.
                            The button labels are from keys: button.label.order and button.label.reset
                    -->
                    
                    <s:if test="events.size>0">
                    <input type="submit" value="Mark as Read" />
                    </s:if>
                     
                </td>
            </tr>
        </table>
    </s:form>