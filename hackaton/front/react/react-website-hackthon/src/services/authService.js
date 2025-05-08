// src/services/authService.js
export async function login(email, password) {
    // Simulação de chamada à API
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (email === 'admin@exemplo.com' && password === '123456') {
          resolve({ token: 'fake-jwt-token', user: { name: 'Admin' } });
        } else {
          reject(new Error('Credenciais inválidas'));
        }
      }, 1000);
    });
  }
  