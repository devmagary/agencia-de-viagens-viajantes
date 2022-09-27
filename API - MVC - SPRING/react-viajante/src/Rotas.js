import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Navbar from './components/Navbar'
import Home from './views/Home'
import EditarViajante from './views/EditarViajante'
import VisualizarViajante from "./views/VisualizarViajante"
import AdicionarViajante from './views/AdicionarViajante'
export default function Rotas() {
  return (
    <Router>
        <Navbar />
        <Routes>
            <Route path="/home" element={<Home />}/>
            <Route path="/add" element={<AdicionarViajante />}/>
            <Route path="/edit/:id" element={<EditarViajante />}/>
            <Route path="/view/:id" element={<VisualizarViajante />}/>
            <Route path="*" element={<h1>Pagina não Encontrada :(</h1>}/>
        </Routes>
    </Router>
  )
}
