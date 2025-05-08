import React from 'react';
import './Carousel.css'; // Arquivo de estilos para o Carrossel
import eventoimg1 from "../../assets/evento1.jpg"
import eventoimg2 from "../../assets/evento5.png"
import eventoimg3 from "../../assets/evento3.png"
import eventoimg4 from "../../assets/evento5.png"
import eventoimg5 from "../../assets/evento1.jpg"
function Carousel() {
  // Array com os dados das imagens e seus respectivos links
  const eventos = [
    { id: 1, imageUrl: eventoimg1, link: '/evento1' },
    { id: 2, imageUrl: eventoimg2, link: '/evento2' },
    { id: 3, imageUrl: eventoimg3, link: '/evento3' },
    { id: 4, imageUrl: eventoimg4, link: '/evento4' }, // Verifique se o nome do arquivo está correto (evento5.png para link /evento4?)
    { id: 5, imageUrl: eventoimg5, link: '/evento5' },
  ];

  
  return (
    <div className="carousel-container">
      <div className="carousel-wrapper">
        {eventos.map((evento) => (
          <div key={evento.id} className="carousel-item">
            <a href={evento.link}>
              <img src={evento.imageUrl} alt={`Evento ${evento.id}`} />
            </a>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Carousel;