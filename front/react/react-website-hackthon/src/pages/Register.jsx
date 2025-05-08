import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Register.css';

function RegisterPage() {
  const [formData, setFormData] = useState({
    login: '', password: '', email: '', phone: '', area: ''
  });
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const allFilled = Object.values(formData).every(val => val.trim() !== '');
    if (!allFilled) {
      setError('Todos os campos são obrigatórios.');
      setSuccess('');
      return;
    }
    console.log('Cadastro:', formData);
    setSuccess('Cadastro realizado!');
    setError('');
  };

  return (
    <div className="register-container">
      <h2>Cadastro</h2>
      {error && <p className="error-message">{error}</p>}
      {success && <p className="success-message">{success}</p>}
      <form onSubmit={handleSubmit} className="register-form">
        <label>Login:
          <input type="text" name="login" value={formData.login} onChange={handleChange} />
        </label>
        <label>Senha:
          <input type="password" name="password" value={formData.password} onChange={handleChange} />
        </label>
        <label>E-mail:
          <input type="email" name="email" value={formData.email} onChange={handleChange} />
        </label>
        <label>Telefone:
          <input type="tel" name="phone" value={formData.phone} onChange={handleChange} />
        </label>
        <label>Área de atuação:
          <input type="text" name="area" value={formData.area} onChange={handleChange} />
        </label>
        <button type="submit">Registrar</button>
        <button type="button" onClick={() => navigate('/pages/Login.jsx')} style={{ marginTop: '1rem' }}>
          Voltar para Login
        </button>
      </form>
    </div>
  );
}

export default RegisterPage;
