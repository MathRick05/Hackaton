import React from 'react';
import Navbar from './components/Navbar/Navbar';
import Footer from './components/Footer/Footer';
import ArtigoDetalhePage from './pages/ArtigoDetalhePage';
import LoginPage from './pages/Login'
import RegisterPage from './pages/Register';
import './App.css'; // Seu arquivo de estilos globais/App

// Ajuste os nomes dos arquivos e componentes importados para corresponder EXATAMENTE aos seus arquivos
import CadastroEventosPage from './pages/CadastroEventosPage'; // Se o arquivo é CadastroEventosPage.jsx
import HomePage from './pages/Home';

import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <>
      <Navbar />
      <main className="main-content">
        <Routes>

          <Route path="/" element={<HomePage />} />

          <Route path="/pages/CadastroEventosPage.jsx" element={<CadastroEventosPage />} />

          <Route path="/artigo/:slugDoArtigo" element={<ArtigoDetalhePage />} />

          <Route path="/pages/Login.jsx" element={<LoginPage />} />

          <Route path="/pages/Register.jsx" element={<RegisterPage />} />
        </Routes>
      </main>
      <Footer />
    </>
  );
}

export default App;