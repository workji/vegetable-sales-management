<#import "/layout/base.ftl" as layout>
<@layout.base title="野菜管理">
    <div class="row mb-3">
        <div class="col">
            <a href="/vsm/vegetables/create" class="btn btn-primary">
                <i class="bi bi-plus-lg"></i> 新規登録
            </a>
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            野菜一覧
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>野菜ID</th>
                        <th>野菜名</th>
                        <th>作成日時</th>
                        <th>更新日時</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <#list vegetables as vegetable>
                        <tr>
                            <td>${vegetable.id}</td>
                            <td>${vegetable.name}</td>
                            <td>${vegetable.createdAt?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${vegetable.updatedAt?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>
                                <div class="btn-group" role="group">
                                    <a href="/vsm/vegetables/${vegetable.id}" class="btn btn-info btn-sm">
                                        <i class="bi bi-eye"></i> 詳細
                                    </a>
                                    <a href="/vsm/vegetables/${vegetable.id}/edit" class="btn btn-warning btn-sm">
                                        <i class="bi bi-pencil"></i> 編集
                                    </a>
                                    <form action="/vsm/vegetables/${vegetable.id}/delete" method="post" style="display: inline;">
                                        <button type="submit" class="btn btn-danger btn-sm delete-vegetable">
                                            <i class="bi bi-trash"></i> 削除
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    <#else>
                        <tr>
                            <td colspan="5" class="text-center">データがありません。</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</@layout.base>