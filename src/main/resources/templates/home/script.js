function listarLivros() {
	fetch('http://localhost:8080/livros')
		.then(response => response.json())
		.then(data => {
			const lista = document.querySelector('#fill_list');
			
			data.map((item) => {
				const li = document.createElement('li');
				li.setAttribute('id', item.id);
				console.log(item);
				lista.appendChild(li);
			})
		})
}