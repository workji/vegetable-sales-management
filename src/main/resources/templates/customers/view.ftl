<#import "../layout/base.ftl" as layout>
<@layout.base title="販売先詳細">
    <div class="card">
        <div class="card-header">
            販売先詳細
        </div>
        <div class="card-body">
            <div class="row mb-3">
                <label class="col-sm-2">顧客ID</label>
                <div class="col-sm-10">
                    ${customer.id}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">顧客名</label>
                <div class="col-sm-10">
                    ${customer.name}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">住所</label>
                <div class="col-sm-10">
                    ${customer.address}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">電話番号</label>
                <div class="col-sm-10">
                    ${customer.phone}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">作成日時</label>
                <div class="col-sm-10">
                    ${customer.createdAt?string('yyyy-MM-dd HH:mm:ss')}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">更新日時</label>
                <div class="col-sm-10">
                    ${customer.updatedAt?string('yyyy-MM-dd HH:mm:ss')}
                </div>
            </div>

            <div class="mt-3">
                <a href="/vsm/customers" class="btn btn-secondary">戻る</a>
                <a href="/vsm/customers/${customer.id}/edit" class="btn btn-warning">
                    <i class="bi bi-pencil"></i> 編集
                </a>
                <form action="/vsm/customers/${customer.id}/delete" method="post" style="display: inline;">
                    <button type="submit" class="btn btn-danger delete-customer">
                        <i class="bi bi-trash"></i> 削除
                    </button>
                </form>
            </div>
        </div>
    </div>
</@layout.base>