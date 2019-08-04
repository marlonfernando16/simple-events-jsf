let especialidades = document.querySelectorAll('.especialidades');
let quantidadevagas = document.querySelectorAll('.quantidadevagas');
console.log($('.especialidades'))

especialidades.forEach((value, indice) => {
	value.addEventListener('change', function () {
		if (this.checked) {
			console.log(quantidadevagas[indice])
			$('.quantidadevagas').eq(indice).removeClass('d-none');
			$('.quantidadevagas').eq(indice).prop("disabled", false);
		} else {
			$('.quantidadevagas').eq(indice).addClass('d-none');
			$('.quantidadevagas').eq(indice).prop("disabled", true);
		}
	})
})