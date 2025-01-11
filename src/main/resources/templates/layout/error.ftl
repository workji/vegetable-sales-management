<#import "/layout/base.ftl" as layout>
<@layout.base title="エラー">
    <div class="alert alert-danger" role="alert">
        <h4 class="alert-heading">エラーが発生しました</h4>
        <p>${message!"予期せぬエラーが発生しました。"}</p>
        <hr>
        <p class="mb-0">
            <a href="javascript:history.back()" class="btn btn-secondary">
                <i class="bi bi-arrow-left"></i> 戻る
            </a>
        </p>
    </div>
</@layout.base>