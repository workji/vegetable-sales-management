/**
 * 顧客管理画面用JavaScript
 */

$(document).ready(function() {
    // 登録・編集フォームのバリデーション
    $('#customerForm').on('submit', function(e) {
        if (!validateForm($(this))) {
            e.preventDefault();
        }
    });

    // 削除ボタンのクリック処理
    $('.delete-customer').on('click', function(e) {
        if (!confirmDelete("この顧客を削除してもよろしいですか？\n※関連する販売情報が存在する場合は削除できません。")) {
            e.preventDefault();
        }
    });

    // 電話番号のフォーマットチェック
    $('#phone').on('change', function() {
        var phone = $(this).val();
        if (phone && !/^\d{2,4}-\d{2,4}-\d{4}$/.test(phone)) {
            showError($(this), "電話番号は「XXX-XXXX-XXXX」の形式で入力してください。");
        } else {
            clearError($(this));
        }
    });
});