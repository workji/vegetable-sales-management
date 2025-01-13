<#import "../layout/base.ftl" as layout>
<@layout.base title="販売情報詳細">
    <div class="card">
        <div class="card-header">
            販売情報詳細
        </div>
        <div class="card-body">
            <div class="row mb-3">
                <label class="col-sm-2">販売ID</label>
                <div class="col-sm-10">
                    ${sale.id}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">野菜</label>
                <div class="col-sm-10">
                    ${sale.vegetableName!""}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">販売先</label>
                <div class="col-sm-10">
                    ${sale.customerName!""}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">数量</label>
                <div class="col-sm-10">
                    ${sale.quantity}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">単価</label>
                <div class="col-sm-10">
                    ${sale.price}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">合計金額</label>
                <div class="col-sm-10">
                    ${(sale.price * sale.quantity)}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">販売日</label>
                <div class="col-sm-10">
                    ${sale.saleDate?string('yyyy-MM-dd')}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">作成日時</label>
                <div class="col-sm-10">
                    ${sale.createdAt?string('yyyy-MM-dd HH:mm:ss')}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2">更新日時</label>
                <div class="col-sm-10">
                    ${sale.updatedAt?string('yyyy-MM-dd HH:mm:ss')}
                </div>
            </div>

            <div class="mt-3">
                <a href="/vsm/sales" class="btn btn-secondary">戻る</a>
                <a href="/vsm/sales/${sale.id}/edit" class="btn btn-warning">
                    <i class="bi bi-pencil"></i> 編集
                </a>
                <form action="/vsm/sales/${sale.id}/delete" method="post" style="display: inline;">
                    <button type="submit" class="btn btn-danger delete-sale">
                        <i class="bi bi-trash"></i> 削除
                    </button>
                </form>
            </div>
        </div>
    </div>
</@layout.base>