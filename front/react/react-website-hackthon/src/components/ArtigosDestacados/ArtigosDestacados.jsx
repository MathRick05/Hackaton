// src/components/ArtigosDestacados/ArtigosDestacados.jsx
import React from 'react';
import { Link } from 'react-router-dom';
import './ArtigosDestacados.css';

// --- 1. IMPORTE AS IMAGENS ---
// O caminho relativo aqui assume que ArtigosDestacados.jsx está em src/components/ArtigosDestacados/
// e as imagens estão em src/assets/images/
// Ajuste '../../assets/images/' conforme sua estrutura de pastas.
import imagemTech from '../../assets/art1.jpg';
import imagemFood from '../../assets/art2.jpg';
import imagemAuto from '../../assets/art3.png';
import avatarAna from '../../assets/saci.png';
import avatarCarlos from '../../assets/olaf.jpg';
import avatarBia from '../../assets/valente.jpg';

// --- 2. USE AS VARIÁVEIS IMPORTADAS NOS DADOS ---
const artigosExemplo = [
    {
        id: 1,
        title: "What's New In 2025 Tech",
        excerpt: 'Uma breve visão sobre as tecnologias emergentes que estão moldando nosso futuro próximo...',
        imageUrl: imagemTech, // Usa a variável importada
        category: 'Tecnologia',
        categoryColor: '#3498db',
        authorName: 'Ana Silva',
        authorAvatarUrl: avatarAna, // Usa a variável importada
        timestamp: '3h atrás',
        link: '/artigo/novidades-tech-2025'
    },
    {
        id: 2,
        title: 'Novas tecnologias para comunidades planejadas',
        excerpt: 'Todos os dias nos deparamos com novidades tecnológicas que geram grandes expectativas e também dúvidas...',
        imageUrl: imagemFood, // Usa a variável importada
        category: 'infraestrutura',
        categoryColor: '#e67e22',
        authorName: 'Carlos Mendes',
        authorAvatarUrl: avatarCarlos, // Usa a variável importada
        timestamp: 'Ontem',
        link: '/artigo/comida-afetiva'
    },
    {
        id: 3,
        title: 'O Futuro dos Carros Elétricos',
        excerpt: 'Uma análise sobre a evolução dos veículos elétricos, sua sustentabilidade...',
        imageUrl: imagemAuto, // Usa a variável importada
        category: 'Automotivo',
        categoryColor: '#e74c3c',
        authorName: 'Beatriz Lima',
        authorAvatarUrl: avatarBia, // Usa a variável importada
        timestamp: '2 dias atrás',
        link: '/artigo/carros-eletricos-futuro'
    },
];

// --- Componente do Card Individual (sem alterações no JSX interno) ---
function ArtigoCard({ artigo }) {
    if (!artigo) {
        return null;
    }
    // O 'src' da imagem agora receberá a variável importada passada via artigo.imageUrl
    return (
        <Link to={artigo.link || '#'} className="artigo-card">
            <div className="artigo-card-imagem-container">
                {artigo.imageUrl ? (
                    <img src={artigo.imageUrl} alt={artigo.title || 'Imagem do artigo'} className="artigo-card-imagem" />
                ) : (
                    <div className="artigo-card-imagem-placeholder">Sem Imagem</div>
                )}
            </div>
            <div className="artigo-card-conteudo">
                {artigo.category && (
                    <span className="artigo-category-tag" style={{ backgroundColor: artigo.categoryColor || 'var(--cor-primaria)' }}>
                        {artigo.category}
                    </span>
                )}
                <h3 className="artigo-title">{artigo.title || 'Título Indisponível'}</h3>
                <p className="artigo-excerpt">{artigo.excerpt || ''}</p>
                <div className="artigo-meta">
                    {artigo.authorAvatarUrl ? (
                        <img src={artigo.authorAvatarUrl} alt={artigo.authorName || ''} className="author-avatar" />
                    ) : (
                        <div className="author-avatar-placeholder"></div>
                    )}
                    <div className="author-info">
                        <span className="author-name">{artigo.authorName || 'Autor Desconhecido'}</span>
                        <span className="timestamp">{artigo.timestamp || ''}</span>
                    </div>
                </div>
            </div>
        </Link>
    );
}

// --- Componente Principal da Seção (sem alterações na lógica) ---
function ArtigosDestacados() {
    return (
        <section className="artigos-destacados-section">
            <h2 className="section-title">Artigos melhor avaliados</h2>
            <div className="artigos-grid">
                {Array.isArray(artigosExemplo) && artigosExemplo.length > 0 ? (
                    artigosExemplo.map(artigo => (
                        <ArtigoCard key={artigo?.id || Math.random()} artigo={artigo} />
                    ))
                ) : (
                    <p>Nenhum artigo em destaque no momento.</p>
                )}
            </div>
        </section>
    );
}

export default ArtigosDestacados;