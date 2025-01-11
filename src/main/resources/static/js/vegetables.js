/**
 * 野菜管理画面用JavaScript
 */

$(document).ready(function() {
    // 登録・編集フォームのバリデーション
    $('#vegetableForm').on('submit', function(e) {
        if (!validateForm($(this))) {
            e.preventDefault();
        }
    });

    // 削除ボタンのクリック処理
    $('.delete-vegetable').on('click', function(e) {
        if (!confirmDelete("この野菜を削除してもよろしいですか？\n※関連する販売情報が存在する場合は削除できません。")) {
            e.preventDefault();
        }
    });
});