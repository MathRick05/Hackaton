// src/components/Navbar/Navbar.jsx
import React from 'react';
import './Navbar.css';
import logo from '../../assets/logo-biopark.png'; // Certifique-se que o caminho está correto
import { FiSearch, FiUser, FiMenu } from 'react-icons/fi'; // Adicionei FiMenu como exemplo
import { Link, useNavigate } from 'react-router-dom';
function Navbar() {
  const navigate = useNavigate();

  const handlePublishClick = () => {
    navigate('../../pages/CadastroEventosPage.jsx'); // Ou a rota correta para "publicar artigo"
  };

  return (
    <nav className="navbar">
      <div className="navbar-left">
        <Link to="/" className="navbar-logo-link"> 
          <img src={logo} alt="Logo Biopark" className="navbar-logo" />
        </Link>
      </div>

      <div className="navbar-center">
        <div className="search-bar">
          {/* Opcional: ícone de menu se você for implementar um menu dropdown */}
          {/* <FiMenu className="menu-icon" />  */}
          <input type="text" placeholder="Pesquisar Artigo" />
          <FiSearch className="search-icon" />
        </div>
      </div>

      <div className="navbar-right">
        {/* Usando o botão com useNavigate ou <Link> estilizado */}
        <button className="publish-button" onClick={handlePublishClick}>
          Publique seu artigo
        </button>
        {/* Ou, se preferir o Link estilizado:
        <Link to="/cadastrar-evento" className="publish-button">
          Publique seu artigo
        </Link>
        */}
        <Link to="/pages/Login.jsx" className="profile-icon-link">
          <FiUser className="profile-icon" /> 
        </Link>

      </div>
    </nav>
  );
}

export default Navbar;