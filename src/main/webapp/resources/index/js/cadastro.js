var input_adm = $("#address");
$('#login-form\\:typeuser').change(function() {
	var option = $('#login-form\\:typeuser option:selected');
	if (option.val() == "JUR") {
		input_adm.removeClass('d-none');
	} else {
		input_adm.addClass('d-none');
	}
});