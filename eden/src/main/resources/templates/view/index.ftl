<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<#list userPage.records as records>
    欢迎 ${records.name} ！
</#list>
</body>
</html>