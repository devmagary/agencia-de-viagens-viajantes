import React, {useState, useEffect} from 'react';
import axios from "axios";
import { useNavigate, Link, useParams } from 'react-router-dom';



export default function Home() {

    const [viajante, setViajante] = useState([]);

    const mostrarTudo = async () => {
        try{
         await axios.get("http://localhost:8080/api/viajante").then((response) => {setViajante(response.data) })   
        }catch (erro){
            alert(erro.message);
        }        
    };

    useEffect(() => {
        mostrarTudo();
    }, [])

	return (
		<div className="container">
			<div className="py-4">
				<table className="table table-striped shadow">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th scope="col">Data Viagem Ida</th>
							<th scope="col">Data Viagem Volta</th>
							<th scope="col">Local</th>
							<th scope="col">-</th>
						</tr>
					</thead>
					<tbody>
                        {viajante.map((viajante, key) => (
						<tr>
                        <th scope="row" key={key}>{key + 1}</th>
                            <td>{viajante.nome}</td>
                            <td>{viajante.data_viagem_ida}</td>
                            <td>{viajante.data_viagem_volta}</td>
                            <td>{viajante.id_local}</td>
                            <td><Link to={`/view/${viajante.id_viajante}`} className="btn btn-outline-success mx-1">Ver</Link></td>
                            <td><Link to={`/edit/${viajante.id_viajante}`} className="btn btn-warning mx-1">Editar Passageiro</Link></td>
                            <td><button className="btn btn-danger mx-1">Adeus Passageiro</button></td>
                        </tr>                        
                        ))}
					
					</tbody>
				</table>
			</div>
		</div>
	);
}
