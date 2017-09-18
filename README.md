# FileUpLoad
<html>
<h2>This application provide simple functionality of uploading files.<h2>

<h>Rest API<h>
<table style="width:60%">
  <tr>
    <th>HTTP method</th>
    <th>Base uri</th>
    <th>using form data?</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>/files</td>
    <td>NO</td>
    <td>Get all files' metadata.</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/files</td>
    <td>YES</td>
    <td>Upload file to server and generate metadata of that file and store it in in-memory database(derby).</td>
  </tr>
   <tr>
    <td>GET</td>
    <td>/files/{id}</td>
    <td>NO</td>
    <td>Get the metadata of the file with the specific {id}.</td>
  </tr>
</table>
<h2>To use form data to upload file, open postman find "form-data" under tag "body" select "file".<h2>
</html>

