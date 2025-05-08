import React from 'react';
import Carousel from '../components/Carousel/Carousel';
import ArtigosDestacados from '../components/ArtigosDestacados/ArtigosDestacados';
import '../App.css'; // usando com css global

// Você pode criar componentes separados para cada seção grande se quiser mais organização
// Ex: import HeroBanner from '../components/HeroBanner/HeroBanner';
// Ex: import ArtigosDestacados from '../components/ArtigosDestacados/ArtigosDestacados';

function HomePage() {
    return (
        <div className="homepage-container">
            {/* Seção do Banner Principal (como no seu modelo) */}
            <section className="eventos-carousel-section">
                <Carousel /> {/* <<--- SEU CARROSSEL ENTRA AQUI */}
                <div className="hero-content">
                    <h1>Seja parte da educação do futuro</h1>
                    <p>Descubra como o Biopark pode transformar sua jornada.</p>
                    {/* Adicione a imagem da moça e outros elementos aqui */}
                </div>
            </section>

            <ArtigosDestacados />


            {/* Outras seções que você queira adicionar à página inicial */}

        </div>
    );
}

export default HomePage;