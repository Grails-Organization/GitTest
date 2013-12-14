
<g:each in="${fileList}" var="value">
<img  src="<g:createLink action="showPayload" id="${value?.id}" />" width="100" />
</g:each>