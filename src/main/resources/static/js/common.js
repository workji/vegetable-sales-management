/**
 * 共通JavaScript関数
 */

// 確認ダイアログを表示する
function confirmDelete(message) {
    return confirm(message || "削除してもよろしいですか？");
}

// フォームのバリデーション
function validateForm(form) {
    var isValid = true;
    form.find('.required').each(function() {
        var input = $(this).find('input, select, textarea');
        if (!input.val()) {
            isValid = false;
            showError(input, "このフィールドは必須です。");
        } else {
            clearError(input);
        }
    });
    return isValid;
}

// エラーメッセージを表示する
function showError(input, message) {
    var formGroup = input.closest('.form-group');
    formGroup.addClass('has-error');
    var errorDiv = formGroup.find('.error-message');
    if (errorDiv.length === 0) {
        errorDiv = $('<div class="error-message"></div>');
        formGroup.append(errorDiv);
    }
    errorDiv.text(message);
}

// エラーメッセージをクリアする
function clearError(input) {
    var formGroup = input.closest('.form-group');
    formGroup.removeClass('has-error');
    formGroup.find('.error-message').remove();
}

// 数値入力のバリデーション
function validateNumber(input) {
    var value = input.val();
    if (value && !/^\d+$/.test(value)) {
        showError(input, "数値を入力してください。");
        return false;
    }
    clearError(input);
    return true;
}

// 日付入力のバリデーション
function validateDate(input) {
    var value = input.val();
    if (value && !/^\d{4}-\d{2}-\d{2}$/.test(value)) {
        showError(input, "正しい日付形式（YYYY-MM-DD）で入力してください。");
        return false;
    }
    clearError(input);
    return true;
}

// ページ読み込み完了時の処理
$(document).ready(function() {
    // 現在のページに対応するメニューをアクティブにする
    $('.nav-link').each(function() {
        if (window.location.pathname.startsWith($(this).attr('href'))) {
            $(this).addClass('active');
        }
    });

    // 必須フィールドのラベルに印を付ける
    $('label').each(function() {
        var input = $('#' + $(this).attr('for'));
        if (input.closest('.required').length > 0) {
            $(this).addClass('required');
        }
    });

    // 数値入力フィールドのバリデーション
    $('input[type="number"]').on('change', function() {
        validateNumber($(this));
    });

    // 日付入力フィールドのバリデーション
    $('input[type="date"]').on('change', function() {
        validateDate($(this));
    });
});