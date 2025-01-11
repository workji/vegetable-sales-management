<#import "/layout/base.ftl" as layout>
<@layout.base title="販売情報管理">
    <div class="row mb-3">
        <div class="col">
            <a href="/vsm/sales/create" class="btn btn-primary">
                <i class="bi bi-plus-lg"></i> 新規登録
            </a>
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            販売情報一覧
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>販売ID</th>
                        <th>販売日</th>
                        <th>野菜名</th>
                        <th>数量</th>
                        <th>単価</th>
                        <th>合計金額</th>
                        <th>販売先</th>
                        <th>作成日時</th>
                        <th>更新日時</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <#list sales as sale>
                        <tr>
                            <td>${sale.id}</td>
                            <td>${sale.saleDate?string('yyyy-MM-dd')}</td>
                            <td>${sale.vegetableName!""}</td>
                            <td>${sale.quantity}</td>
                            <td>${sale.price}</td>
                            <td>${(sale.price * sale.quantity)}</td>
                            <td>${sale.customerName!""}</td>
                            <td>${sale.createdAt?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${sale.updatedAt?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>
                                <div class="btn-group" role="group">
                                    <a href="/vsm/sales/${sale.id}" class="btn btn-info btn-sm">
                                        <i class="bi bi-eye"></i> 詳細
                                    </a>
                                    <a href="/vsm/sales/${sale.id}/edit" class="btn btn-warning btn-sm">
                                        <i class="bi bi-pencil"></i> 編集
                                    </a>
                                    <form action="/vsm/sales/${sale.id}/delete" method="post" style="display: inline;">
                                        <button type="submit" class="btn btn-danger btn-sm delete-sale">
                                            <i class="bi bi-trash"></i> 削除
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    <#else>
                        <tr>
                            <td colspan="10" class="text-center">データがありません。</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</@layout.base>