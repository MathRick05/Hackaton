import React from 'react';
import './Footer.css'; // Arquivo de estilos para o Footer
import { MdEmail, MdPhone, MdWhatsapp } from 'react-icons/md'; // Importe mais ícones

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-links">
        <h3>Dúvidas frequentes</h3>
        <a href="/publicar-artigo">Tem interesse em publicar seu artigo? Saiba como!</a>
        <a href="/criterios-avaliacao">Saiba mais sobre os critérios de avaliação.</a>
        <a href="/avaliadores">Conheça alguns de nossos avaliadores.</a>
      </div>
      <div className="footer-contact">
        <h3>Fale Conosco</h3>
        <div className="contact-item">
          <MdEmail className="contact-icon" />
          <span>E-mail:</span>
          <a href="mailto:comercial@bpkedu.com.br">comercial@bpkedu.com.br</a>
        </div>
        <div className="contact-item">
          <MdPhone className="contact-icon" />
          <span>Telefone:</span>
          <span>(45) 2036 - 3618</span>
        </div>
        <div className="contact-item">
          <MdWhatsapp className="contact-icon" />
          <span>WhatsApp:</span>
          <span>(45) 9 9147 - 6872</span>
        </div>
      </div>
    </footer>
  );
}

export default Footer;