<!DOCTYPE html>
<html>
	<head>
		<title>Grails Runtime Exception</title>
		<meta name="layout" content="main">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css">
	</head>
	<body>
		<g:set var="test" value="${true}"/>
		Testing ${test }
		Upload Form: <br />
    <g:uploadForm name="myUpload" action="upload">
    <input type="file" name="filePayload" />
    <input type="submit" value="Upload">
     </g:uploadForm>
    
	</body>
</html>