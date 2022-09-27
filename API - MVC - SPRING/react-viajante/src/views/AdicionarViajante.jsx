import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

export default function AdicionarViajante() {
	const navigate = useNavigate();
	const [nome, setNome] = useState('');
	const [data_viagem_ida, setData_viagem_ida] = useState('');
	const [data_viagem_volta, setData_viagem_volta] = useState('');
	const [id_Local, setId_local] = useState('');

	const salvar = async e => {
		e.preventDefault();
		console.log(nome, data_viagem_ida, data_viagem_volta, id_Local);
		await axios
			.post('http://localhost:8080/api/viajante', {
				nome: nome,
				data_viagem_ida: data_viagem_ida,
				data_viagem_volta: data_viagem_volta,
				id_local: id_Local,
			})
			.then(result => {
				alert('Viajante Cadastrado');
				navigate('/home');
			})
			.catch(erro => {
				console.log(erro);
			});
	};

	return (
		<div className="container">
			<div className="row">
				<div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
					<h2 className="text-center m-4">Cadastro do Viajante</h2>
					<form>
						<div className="mb-3">
							<label for="exampleInputNome" className="form-label">
								Nome
							</label>
							<input
								type="text"
								className="form-control"
								id="exampleInputNome"
								value={nome}
								onChange={e => setNome(e.target.value)}
							/>
						</div>
						<div className="mb-3">
							<label for="exampleInputDataIda" className="form-label">
								Data Viagem - IDA
							</label>
							<input
								type="date"
								className="form-control"
								id="exampleInputDataIda"
								value={data_viagem_ida}
								onChange={e => setData_viagem_ida(e.target.value)}
							/>
						</div>
						<div className="mb-3">
							<label for="exampleInputDataVolta" className="form-label">
								Data Viagem - Volta
							</label>
							<input
								type="date"
								className="form-control"
								id="exampleInputDataVolta"
								aria-describedby="emailHelp"
								value={data_viagem_volta}
								onChange={e => setData_viagem_volta(e.target.value)}
							/>
						</div>
						<div className="mb-3">
							<label for="exampleInputIdlocal" className="form-label">
								id_local
							</label>
							<input
								type="number"
								className="form-control"
								id="exampleInputIdlocal"
								aria-describedby="emailHelp"
								value={id_Local}
								onChange={e => setId_local(e.target.value)}
							/>
						</div>
						<Link to="/home" type="submit" className="mx-2 btn btn-primary" onClick={salvar}>
							Cadastrar
						</Link>
						<button type="submit" className="btn btn-outline-danger">
							Cancelar
						</button>
					</form>
				</div>
			</div>
		</div>
	);
}
