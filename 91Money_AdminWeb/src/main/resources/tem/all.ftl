<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Freemarker</title>
</head>
<body>
<h2>${msg}</h2>
<hr>
对象
<div>
    <h4>${sysuser.email}</h4>
    <h4>${sysuser.mobile}</h4>
    <h4>${sysuser.username}</h4>
</div>
集合
<ul>
    <#list list as li>
        <li>序号:${li_index},内容:${li}</li>
    </#list>
</ul>
分支--奇数  可以提添加判断
<ul>
    <#list list as li>
        <#if li_index%2==1>
            <li>序号：${li_index},内容：${li}</li>
        </#if>
    </#list>
</ul>

</body>
</html>