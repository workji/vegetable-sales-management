/**
 * 販売情報管理画面用JavaScript
 */

$(document).ready(function() {
    // 登録・編集フォームのバリデーション
    $('#saleForm').on('submit', function(e) {
        if (!validateForm($(this))) {
            e.preventDefault();
            return;
        }

        // 数量のチェック
        var quantity = $('#quantity').val();
        if (quantity <= 0) {
            showError($('#quantity'), "数量は1以上を入力してください。");
            e.preventDefault();
            return;
        }

        // 単価のチェック
        var price = $('#price').val();
        if (price <= 0) {
            showError($('#price'), "単価は1以上を入力してください。");
            e.preventDefault();
            return;
        }
    });

    // 削除ボタンのクリック処理
    $('.delete-sale').on('click', function(e) {
        if (!confirmDelete("この販売情報を削除してもよろしいですか？")) {
            e.preventDefault();
        }
    });

    // 単価の入力制限（小数点2桁まで）
    $('#price').on('change', function() {
        var price = $(this).val();
        if (price && !/^\d+(\.\d{0,2})?$/.test(price)) {
            showError($(this), "単価は整数または小数点2桁までで入力してください。");
        } else {
            clearError($(this));
        }
    });
});