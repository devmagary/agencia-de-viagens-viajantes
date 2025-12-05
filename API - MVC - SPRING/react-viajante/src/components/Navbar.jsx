import React from 'react';
import { Link } from 'react-router-dom';
export default function Navbar() {
	return (
		<div>
			<nav className="navbar navbar-expand-lg bg-primary">
				<div className="container-fluid">
					<Link className="navbar-brand text-light" to="/home">
						Viajantes
					</Link>
					<button
						className="navbar-toggler"
						type="button"
						data-bs-toggle="collapse"
						data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent"
						aria-expanded="false"
						aria-label="Toggle navigation"
					>
						<span className="navbar-toggler-icon"></span>
					</button>
					<div className="collapse navbar-collapse" id="navbarSupportedContent">
						<ul className="navbar-nav me-auto mb-2 mb-lg-0">
							<li className="nav-item">
								<Link to="/Home" className="nav-link text-light active" aria-current="page">
									Home
								</Link>
							</li>
						</ul>
					</div>
                    <Link to="/add" className="btn btn-success mx-2">Compre sua Passagem </Link>
				</div>
			</nav>
		</div>
	);
}
