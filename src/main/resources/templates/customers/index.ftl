<#import "/layout/base.ftl" as layout>
<@layout.base title="販売先管理">
    <div class="row mb-3">
        <div class="col">
            <a href="/vsm/customers/create" class="btn btn-primary">
                <i class="bi bi-plus-lg"></i> 新規登録
            </a>
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            販売先一覧
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>顧客ID</th>
                        <th>顧客名</th>
                        <th>住所</th>
                        <th>電話番号</th>
                        <th>作成日時</th>
                        <th>更新日時</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <#list customers as customer>
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.name}</td>
                            <td>${customer.address}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.createdAt?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${customer.updatedAt?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>
                                <div class="btn-group" role="group">
                                    <a href="/vsm/customers/${customer.id}" class="btn btn-info btn-sm">
                                        <i class="bi bi-eye"></i> 詳細
                                    </a>
                                    <a href="/vsm/customers/${customer.id}/edit" class="btn btn-warning btn-sm">
                                        <i class="bi bi-pencil"></i> 編集
                                    </a>
                                    <form action="/vsm/customers/${customer.id}/delete" method="post" style="display: inline;">
                                        <button type="submit" class="btn btn-danger btn-sm delete-customer">
                                            <i class="bi bi-trash"></i> 削除
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    <#else>
                        <tr>
                            <td colspan="7" class="text-center">データがありません。</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</@layout.base>