<#import "/layout/base.ftl" as layout>
<@layout.base title="野菜詳細">
    <div class="card">
        <div class="card-header">
            野菜詳細
        </div>
        <div class="card-body">
            <div class="row mb-3">
                <label class="col-sm-2">野菜ID</label>
                <div class="col-sm-10">
                    ${vegetable.id}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">野菜名</label>
                <div class="col-sm-10">
                    ${vegetable.name}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">作成日時</label>
                <div class="col-sm-10">
                    ${vegetable.createdAt?string('yyyy-MM-dd HH:mm:ss')}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">更新日時</label>
                <div class="col-sm-10">
                    ${vegetable.updatedAt?string('yyyy-MM-dd HH:mm:ss')}
                </div>
            </div>

            <div class="mt-3">
                <a href="/vsm/vegetables" class="btn btn-secondary">戻る</a>
                <a href="/vsm/vegetables/${vegetable.id}/edit" class="btn btn-warning">
                    <i class="bi bi-pencil"></i> 編集
                </a>
                <form action="/vsm/vegetables/${vegetable.id}/delete" method="post" style="display: inline;">
                    <button type="submit" class="btn btn-danger delete-vegetable">
                        <i class="bi bi-trash"></i> 削除
                    </button>
                </form>
            </div>
        </div>
    </div>
</@layout.base>