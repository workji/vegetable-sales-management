<#import "../layout/base.ftl" as layout>
<@layout.base title="野菜編集">
    <div class="card">
        <div class="card-header">
            野菜編集
        </div>
        <div class="card-body">
            <form id="vegetableForm" action="/vegetables/update/${vegetable.id}" method="post">
                <div class="form-group required">
                    <label for="name">野菜名</label>
                    <input type="text" class="form-control" id="name" name="name" 
                           value="${vegetable.name}" maxlength="100" required>
                </div>

                <div class="mt-3">
                    <a href="/vegetables" class="btn btn-secondary">キャンセル</a>
                    <button type="submit" class="btn btn-primary">更新</button>
                </div>
            </form>
        </div>
    </div>
</@layout.base>