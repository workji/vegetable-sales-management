<#macro base title><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title!"野菜販売管理システム"}</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-2 sidebar">
                <div class="d-flex flex-column">
                    <h3 class="px-3 py-4 mb-0 text-white">メニュー</h3>
                    <nav class="nav flex-column">
                        <a class="nav-link" href="/vegetables">野菜管理</a>
                        <a class="nav-link" href="/customers">販売先管理</a>
                        <a class="nav-link" href="/sales">販売情報管理</a>
                        <a class="nav-link" href="/reports/monthly">月別売上情報</a>
                    </nav>
                </div>
            </div>

            <!-- Main content -->
            <div class="col-md-10 main-content">
                <h2 class="page-header">${title!"野菜販売管理システム"}</h2>
                <#if message??>
                    <div class="alert alert-${messageType!'info'} alert-dismissible fade show" role="alert">
                        ${message}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </#if>
                <#nested>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom JS -->
    <script src="/js/common.js"></script>
    <#if scripts??>
        <#list scripts as script>
            <script src="${script}"></script>
        </#list>
    </#if>
</body>
</html></#macro>